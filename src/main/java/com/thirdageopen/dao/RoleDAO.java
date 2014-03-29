package com.thirdageopen.dao;

import com.thirdageopen.domain.Role;


public interface RoleDAO extends BaseDao<Role>{
	
	public Role getRole(int id);

}
