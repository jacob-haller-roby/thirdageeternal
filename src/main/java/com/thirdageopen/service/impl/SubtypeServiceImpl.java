package com.thirdageopen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thirdageopen.dao.SubtypeDAO;
import com.thirdageopen.domain.Subtype;
import com.thirdageopen.service.SubtypeService;

@Service
@Transactional
public class SubtypeServiceImpl extends BaseCRUDServiceImpl<Subtype> implements SubtypeService{

	@Autowired
	private SubtypeDAO SubtypeDAO;
	
	
	@Override
	public void create(Subtype object) {
		SubtypeDAO.save(object);
	}

	@Override
	public List<Subtype> retrieve() {
		return SubtypeDAO.all();
	}

	@Override
	public void update(Subtype object) {
		SubtypeDAO.update(object);
	}

	@Override
	public void delete(Subtype object) {
		SubtypeDAO.delete(object);
	}

}
