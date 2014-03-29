package com.thirdageopen.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.opensaml.xml.util.Pair;



public abstract interface BaseDao<Domain> {

	public List<Domain> all(int maxResults);

	public List<Domain> all();

	public Domain find(Integer id);

	public Integer save(Domain object);

	public void update(Domain object);

	public void delete(Domain object);

	public CriteriaWrapper<Domain> startCall();

	abstract interface CriteriaWrapper<Domain> {

		public List<Domain> list();

		public List<Domain> list(Integer page);

		public <ReportType> List<ReportType> report(
				Class<ReportType> reportClass);

		public CriteriaWrapper<Domain> exactMatch(Map<String, Object> input);

		public CriteriaWrapper<Domain> exactMatch(String fieldName, Object value);

		public CriteriaWrapper<Domain> doesNotMatch(String fieldName,
				Object value);

		public CriteriaWrapper<Domain> startsWith(Map<String, String> input);

		public CriteriaWrapper<Domain> startsWith(String fieldName, String value);

		public CriteriaWrapper<Domain> createdAfter(Date input);

		public CriteriaWrapper<Domain> createdBefore(Date input);

		public CriteriaWrapper<Domain> projections(List<String> groupings,
				Map<String, String> counts, Map<String, String> properties,
				Boolean averageDuration);

		public CriteriaWrapper<Domain> sortings(
				List<Pair<String, Boolean>> input);

		public CriteriaWrapper<Domain> sorting(String fieldName,
				Boolean ascending);

		public CriteriaWrapper<Domain> isActive();

		public CriteriaWrapper<Domain> isActive(String entity);

		public CriteriaWrapper<Domain> aliasOff();
		
		public CriteriaWrapper<Domain> setOrder(String field, Boolean ascending);
		
		public CriteriaWrapper<Domain> paginated(Integer itemsPerPage, Integer page);

	};

}
