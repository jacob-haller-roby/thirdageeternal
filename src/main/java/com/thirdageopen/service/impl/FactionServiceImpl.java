package com.thirdageopen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thirdageopen.dao.FactionDAO;
import com.thirdageopen.domain.Faction;
import com.thirdageopen.service.FactionService;

@Service
@Transactional
public class FactionServiceImpl extends BaseCRUDServiceImpl<Faction> implements FactionService{

	@Autowired
	private FactionDAO FactionDAO;
	
	
	@Override
	public void create(Faction object) {
		FactionDAO.save(object);
	}

	@Override
	public List<Faction> retrieve() {
		return FactionDAO.all();
	}

	@Override
	public void update(Faction object) {
		FactionDAO.update(object);
	}

	@Override
	public void delete(Faction object) {
		FactionDAO.delete(object);
	}

}
