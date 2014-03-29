package com.thirdageopen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thirdageopen.dao.RoleDAO;
import com.thirdageopen.domain.Role;
import com.thirdageopen.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl extends BaseCRUDServiceImpl<Role> implements RoleService {

	@Autowired
	private RoleDAO roleDAO;
	
	@Override
	public void create(Role object) {
		roleDAO.save(object);
	}

	@Override
	public List<Role> retrieve() {
		return roleDAO.all();
	}

	@Override
	public void update(Role object) {
		roleDAO.update(object);
	}

	@Override
	public void delete(Role object) {
		roleDAO.delete(object);
	}

	@Override
	public Role getRole(int id) {
		return roleDAO.getRole(id);
	}
	
	

}
