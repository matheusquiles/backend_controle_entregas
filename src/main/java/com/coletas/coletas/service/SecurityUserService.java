package com.coletas.coletas.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.coletas.coletas.model.SecurityUser;
import com.coletas.coletas.model.Users;

public interface SecurityUserService extends BaseService<SecurityUser, Integer> {
	
	void save(Users entity);
	Boolean login(Users user);
	UserDetails loadUserByUsername(String userKey);

}
