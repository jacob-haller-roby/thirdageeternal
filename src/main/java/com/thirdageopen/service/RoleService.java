package com.thirdageopen.service;

import com.thirdageopen.domain.Role;

public interface RoleService extends BaseCRUDService<Role>{
	
	public Role getRole(int id);

}
