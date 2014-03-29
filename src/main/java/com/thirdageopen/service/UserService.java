package com.thirdageopen.service;

import com.thirdageopen.domain.User;

public interface UserService extends BaseCRUDService<User>{
	
	public User getUser(String login);

	public User getCurrentUser();
}
