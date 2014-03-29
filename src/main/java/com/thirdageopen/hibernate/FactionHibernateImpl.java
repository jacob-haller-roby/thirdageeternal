package com.thirdageopen.hibernate;

import org.springframework.stereotype.Repository;

import com.thirdageopen.dao.FactionDAO;
import com.thirdageopen.domain.Faction;

@Repository
public class FactionHibernateImpl extends BaseHibernateImpl<Faction> implements FactionDAO{

	public FactionHibernateImpl() {
		type = new Faction();
	}
}
