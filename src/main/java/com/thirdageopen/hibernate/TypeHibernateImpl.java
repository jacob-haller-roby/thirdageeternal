package com.thirdageopen.hibernate;

import org.springframework.stereotype.Repository;

import com.thirdageopen.dao.TypeDAO;
import com.thirdageopen.domain.Type;

@Repository
public class TypeHibernateImpl extends BaseHibernateImpl<Type> implements TypeDAO{
	
	public TypeHibernateImpl() {
		type = new Type();
	}

}
