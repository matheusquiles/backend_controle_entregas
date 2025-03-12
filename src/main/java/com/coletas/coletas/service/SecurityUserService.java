package com.coletas.coletas.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.coletas.coletas.model.SecurityUser;
import com.coletas.coletas.model.Users;

public interface SecurityUserService extends BaseService<SecurityUser, Integer> {
	
	Boolean save(Users entity, String string);
	Boolean login(Users user);
	UserDetails loadUserByUsername(String userKey);
	Boolean changePassord(Users user);

}
