package com.coletas.coletas.dao;

import java.util.Optional;

import com.coletas.coletas.model.SecurityUser;

public interface SecurityUserDAO extends BaseDAO<SecurityUser, Integer> {
	Optional<SecurityUser> getByDescription(String securityUser); 
	Optional<SecurityUser> getByUserId(Integer idUser);

}
