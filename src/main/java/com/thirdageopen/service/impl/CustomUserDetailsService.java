package com.thirdageopen.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thirdageopen.dao.UserDAO;
import com.thirdageopen.domain.Role;
import com.thirdageopen.domain.User;

@Service
@Transactional(readOnly = true)
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public UserDetails loadUserByUsername(String login)
			throws UsernameNotFoundException {

		User user = userDAO.getUser(login);
		
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpried = true;
		boolean accountNonLocked = true;

		return new org.springframework.security.core.userdetails.User(
				user.getLogin(), user.getPassword(), enabled,
				accountNonExpired, credentialsNonExpried, accountNonLocked,
				getAuthorities(user.getRoles()));
	}

	public Collection<? extends GrantedAuthority> getAuthorities(
			List<Role> roles) {
		List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(roles));
		return authList;
	}

	public List<String> getRoles(List<Role> roles) {
		List<String> authorities = new ArrayList<String>();
		authorities.add("ROLE_BASIC");
		if (!roles.isEmpty()) {
			for (Role role : roles) {
				authorities.add(role.getRole());
			}
		}
		return authorities;
	}

	public static List<GrantedAuthority> getGrantedAuthorities(
			List<String> roles) {

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}

}
