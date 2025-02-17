package com.coletas.coletas.service;

import com.coletas.coletas.model.SecurityUser;
import com.coletas.coletas.model.Users;

public interface SecurityUserService extends BaseService<SecurityUser, Integer> {
	
	void save(Users entity);

}
