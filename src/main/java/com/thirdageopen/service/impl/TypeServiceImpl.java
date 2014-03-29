package com.thirdageopen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thirdageopen.dao.TypeDAO;
import com.thirdageopen.domain.Type;
import com.thirdageopen.service.TypeService;

@Service
@Transactional
public class TypeServiceImpl extends BaseCRUDServiceImpl<Type> implements TypeService{

	@Autowired
	private TypeDAO TypeDAO;
	
	
	@Override
	public void create(Type object) {
		TypeDAO.save(object);
	}

	@Override
	public List<Type> retrieve() {
		return TypeDAO.all();
	}

	@Override
	public void update(Type object) {
		TypeDAO.update(object);
	}

	@Override
	public void delete(Type object) {
		TypeDAO.delete(object);
	}

}
