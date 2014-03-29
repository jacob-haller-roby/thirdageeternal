package com.thirdageopen.hibernate;

import org.springframework.stereotype.Repository;

import com.thirdageopen.dao.CardDAO;
import com.thirdageopen.domain.Card;

@Repository
public class CardHibernateImpl extends BaseHibernateImpl<Card> implements CardDAO{
	
	public CardHibernateImpl() {
		type = new Card();
	}

}
