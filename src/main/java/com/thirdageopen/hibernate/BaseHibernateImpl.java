package com.thirdageopen.hibernate;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StringType;
import org.hibernate.type.Type;
import org.opensaml.xml.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.thirdageopen.dao.BaseDao;

@Transactional
public abstract class BaseHibernateImpl<Domain> implements BaseDao<Domain> {

	@Autowired
	protected SessionFactory sessionFactory;

	protected Domain type;

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Domain> all(int maxResults) {
		return getCurrentSession().createCriteria(type.getClass())
				.setMaxResults(maxResults).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Domain> all() {
		return getCurrentSession().createCriteria(type.getClass()).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Domain find(Integer id) {
		return (Domain) getCurrentSession().get(type.getClass(), id);
	}

	@Override
	public Integer save(Domain object) {
		return (Integer) getCurrentSession().save(object);
	}

	@Override
	public void update(Domain object) {
		getCurrentSession().update(object);
	}

	@Override
	public void delete(Domain object) {
		getCurrentSession().delete(object);
	}

	@Override
	public CriteriaManager startCall() {
		return new CriteriaManager();
	}

	/**
	 * @author Jake
	 * 
	 * @param <Domain>
	 * 
	 *            Criteria Manager is a Criteria Wrapping class to handle
	 *            criteria creation in a modular way. Functions are meant to be
	 *            chained and to extend the existing Criteria interface into a
	 *            more user-friendly model
	 */
	class CriteriaManager implements CriteriaWrapper<Domain> {

		private Criteria criteria;
		private Domain managerType;
		private Session session;
		private List<String> aliasList;
		private Boolean aliasOff;

		protected CriteriaManager() {
			this.session = sessionFactory.openSession();
			this.managerType = type;
			this.criteria = session.createCriteria(managerType.getClass());
			this.aliasList = new ArrayList<String>();
			this.aliasOff = false;
		}

		public CriteriaManager aliasOff() {
			this.aliasOff = true;
			return this;
		}

		@SuppressWarnings("unchecked")
		public List<Domain> list() {
			List<Domain> domains = this.criteria.list();
			this.session.close();
			return domains;
		}

		@SuppressWarnings("unchecked")
		public <ReportType> List<ReportType> report(
				Class<ReportType> reportClass) {
			this.criteria.setResultTransformer(Transformers
					.aliasToBean(reportClass));
			List<ReportType> report = this.criteria.list();
			this.session.close();
			return report;
		}

		@SuppressWarnings("unchecked")
		public List<Domain> list(Integer page) {
			List<Domain> domains = this.criteria.list();
			this.session.close();

			if (page == null) {
				return domains;
			}

			if ((page - 1) * 10 > domains.size()) {
				return null;
			}

			int sublistEnd = page * 10;
			if (sublistEnd > domains.size()) {
				sublistEnd = domains.size();
			}

			return domains.subList((page - 1) * 10, sublistEnd);

		}

		private String makeAlias(String fieldName) {
			if (this.aliasOff) {
				return fieldName;
			}

			String aliasString = "";

			while (fieldName.contains(".")) {
				String previousAlias = aliasString;
				if (!previousAlias.equals("")) {
					previousAlias = previousAlias + ".";
				}
				String currentAliasSnippet = StringUtils.split(fieldName, ".")[0];
				aliasString = aliasString + currentAliasSnippet;
				if (!this.aliasList.contains(aliasString)) {
					System.out.println("ALIAS CREATED: " + aliasString);
					this.criteria.createAlias(previousAlias
							+ currentAliasSnippet, aliasString);
					this.aliasList.add(aliasString);
				}
				fieldName = StringUtils.split(fieldName, ".")[1];
			}

			String[] fieldNameArray = StringUtils.delimitedListToStringArray(
					fieldName, ".");
			if (!aliasString.isEmpty()) {
				System.err.println("empty: " + aliasString + "."
						+ fieldNameArray[fieldNameArray.length - 1]);
				return aliasString + "."
						+ fieldNameArray[fieldNameArray.length - 1];
			}
			System.err.println("full " + fieldName);
			return fieldName;
		}

		public CriteriaManager exactMatch(Map<String, Object> input) {

			for (String key : input.keySet()) {
				exactMatch(key, input.get(key));
			}

			return this;
		}

		public CriteriaManager doesNotMatch(String fieldName, Object value) {
			fieldName = makeAlias(fieldName);
			this.criteria.add(value == null ? Restrictions.isNotNull(fieldName)
					: Restrictions.ne(fieldName, value));
			return this;
		}

		public CriteriaManager exactMatch(String fieldName, Object value) {
			fieldName = makeAlias(fieldName);

			Criterion criterion;
			if (value == null) {
				criterion = Restrictions.isNull(fieldName);
			} else if (value instanceof Collection<?>) {
				Collection<?> collection = (Collection<?>) value;
				criterion = Restrictions.in(fieldName, collection);
			} else {
				criterion = Restrictions.eq(fieldName, value);
			}
			this.criteria.add(criterion);

			return this;
		}

		public CriteriaManager startsWith(Map<String, String> input) {

			for (String key : input.keySet()) {
				startsWith(key, input.get(key));
			}

			return this;
		}

		public CriteriaManager startsWith(String fieldName, String value) {

			fieldName = makeAlias(fieldName);
			this.criteria.add(Restrictions.like(fieldName, value + "%"));

			return this;

		}

		public CriteriaManager createdAfter(Date input) {
			this.criteria.add(Restrictions.ge("createdAt", input));
			return this;
		}

		public CriteriaManager createdBefore(Date input) {
			this.criteria.add(Restrictions.lt("createdAt", input));
			return this;
		}

		public CriteriaManager projections(List<String> groupings,
				Map<String, String> counts, Map<String, String> properties,
				Boolean averageDuration) {

			ProjectionList projectionList = Projections.projectionList();

			for (String grouping : groupings) {
				String fieldName = grouping;
				fieldName = makeAlias(fieldName);
				projectionList.add(Projections.groupProperty(fieldName));
			}

			for (String alias : counts.keySet()) {
				String count = counts.get(alias);
				String fieldName = count;
				fieldName = makeAlias(fieldName);
				projectionList.add(Projections.count(fieldName), alias);
			}

			for (String alias : properties.keySet()) {
				String property = properties.get(alias);
				String fieldName = property;
				fieldName = makeAlias(fieldName);
				projectionList.add(Projections.property(fieldName), alias);
			}

			if (averageDuration) {
				projectionList.add(Projections.sqlProjection(
						"avg(this_.SYS_CLOS_DT - this_.SYS_OPN_DT) as avgDays",
						new String[] { "avgDays" },
						new Type[] { new StringType() }));
			}

			this.criteria.setProjection(projectionList);

			return this;
		}

		public CriteriaManager sortings(List<Pair<String, Boolean>> input) {

			for (Pair<String, Boolean> sorting : input) {
				sorting(sorting.getFirst(), sorting.getSecond());
			}

			return this;
		}

		public CriteriaManager sorting(String fieldName, Boolean ascending) {

			fieldName = makeAlias(fieldName);
			if (ascending) {
				this.criteria.addOrder(Order.asc(fieldName));
			} else {
				this.criteria.addOrder(Order.desc(fieldName));
			}

			return this;

		}

		public CriteriaManager isActive(String entity) {

			String fieldName = makeAlias(entity + ".endAt");

			Disjunction disjunction = Restrictions.disjunction();
			disjunction.add(Restrictions.isNull(fieldName));
			disjunction.add(Restrictions.ge(fieldName,
					new Timestamp(new Date().getTime())));

			fieldName = makeAlias(entity + ".effectiveAt");

			this.criteria.add(disjunction);
			this.criteria.add(Restrictions.le(fieldName, new Timestamp(
					new Date().getTime())));
			return this;
		}

		public CriteriaManager isActive() {

			Disjunction disjunction = Restrictions.disjunction();
			disjunction.add(Restrictions.isNull("endAt"));
			disjunction.add(Restrictions.ge("endAt",
					new Timestamp(new Date().getTime())));

			this.criteria.add(disjunction);
			this.criteria.add(Restrictions.le("effectiveAt", new Timestamp(
					new Date().getTime())));
			return this;
		}
		
		public CriteriaManager setOrder(String field, Boolean ascending){
			if(ascending){
				this.criteria.addOrder(Order.asc(field));
			} else {
				this.criteria.addOrder(Order.desc(field));
			}
			
			return this;
		}
		
		public CriteriaManager paginated(Integer itemsPerPage, Integer page){
			this.criteria.setFirstResult(itemsPerPage * page);
			this.criteria.setMaxResults(itemsPerPage);
			this.criteria.setFetchSize(itemsPerPage);
			return this;
		}
	}

}