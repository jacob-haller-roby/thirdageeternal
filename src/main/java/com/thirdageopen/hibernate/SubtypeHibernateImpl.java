package com.thirdageopen.hibernate;

import org.springframework.stereotype.Repository;

import com.thirdageopen.dao.SubtypeDAO;
import com.thirdageopen.domain.Subtype;

@Repository
public class SubtypeHibernateImpl extends BaseHibernateImpl<Subtype> implements SubtypeDAO{

	public SubtypeHibernateImpl() {
		type = new Subtype();
	}
}
