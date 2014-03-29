package com.thirdageopen.dao;

import com.thirdageopen.domain.User;

public interface UserDAO extends BaseDao<User> {
	
	public User getUser(String login);

}
