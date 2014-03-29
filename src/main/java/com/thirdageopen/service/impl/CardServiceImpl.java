package com.thirdageopen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thirdageopen.dao.CardDAO;
import com.thirdageopen.domain.Card;
import com.thirdageopen.service.CardService;

@Service
@Transactional
public class CardServiceImpl extends BaseCRUDServiceImpl<Card> implements CardService{

	@Autowired
	private CardDAO CardDAO;
	
	
	@Override
	public void create(Card object) {
		CardDAO.save(object);
	}

	@Override
	public List<Card> retrieve() {
		return CardDAO.all();
	}

	@Override
	public void update(Card object) {
		CardDAO.update(object);
	}

	@Override
	public void delete(Card object) {
		CardDAO.delete(object);
	}

}
