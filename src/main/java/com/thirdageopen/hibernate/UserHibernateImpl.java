package com.thirdageopen.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thirdageopen.dao.UserDAO;
import com.thirdageopen.domain.User;

@Repository
@Transactional
public class UserHibernateImpl extends BaseHibernateImpl<User> implements UserDAO{
	
	public UserHibernateImpl(){
		type = new User();
	}

	@Override
	public User getUser(String login) {
		
		List<User> users = startCall().exactMatch("login", login).list();
		if(users.size() > 0){
			return users.get(0);
		}
		return null;
	}
	
}
