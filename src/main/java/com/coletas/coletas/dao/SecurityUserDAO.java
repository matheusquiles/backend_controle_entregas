package com.coletas.coletas.dao;

import java.util.Optional;

import com.coletas.coletas.model.SecurityUser;

public interface SecurityUserDAO extends BaseDAO<SecurityUser, Integer> {
	Optional<SecurityUser> getByDescription(String securityUser); 
	SecurityUser getByUserId(Integer idUser);
	SecurityUser getByUserKey(String userKey);

}
