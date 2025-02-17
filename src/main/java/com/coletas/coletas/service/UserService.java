package com.coletas.coletas.service;

import com.coletas.coletas.model.Users;

public interface UserService extends BaseService<Users, Integer> {
	
	Boolean searchUser(String userKey);
	Boolean saveUser(Users user);
	Users getUserByKey(String userKey);

}
