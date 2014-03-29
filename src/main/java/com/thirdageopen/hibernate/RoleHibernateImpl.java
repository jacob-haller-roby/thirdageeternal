package com.thirdageopen.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.thirdageopen.dao.RoleDAO;
import com.thirdageopen.domain.Role;

@Repository
public class RoleHibernateImpl extends BaseHibernateImpl<Role> implements RoleDAO{
	
	public RoleHibernateImpl() {
		type = new Role();
	}
	

	@Override
	public Role getRole(int id) {
		List<Role> roles = startCall().exactMatch("id", id).list();
		if(roles.size() > 0){
			return roles.get(0);
		}
		return null;
	}

}
