package com.thirdageopen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thirdageopen.dao.UserDAO;
import com.thirdageopen.domain.User;
import com.thirdageopen.service.UserService;

@Service
@Transactional
public class UserServiceImpl extends BaseCRUDServiceImpl<User> implements
		UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public User getCurrentUser() {
		org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		return getUser(user.getUsername());
	}

	@Override
	public void create(User object) {
		userDAO.save(object);
	}

	@Override
	public List<User> retrieve() {
		return userDAO.all();
	}

	@Override
	public void update(User object) {
		userDAO.update(object);
	}

	@Override
	public void delete(User object) {
		userDAO.delete(object);
	}

	@Override
	public User getUser(String login) {
		return userDAO.getUser(login);
	}

}
