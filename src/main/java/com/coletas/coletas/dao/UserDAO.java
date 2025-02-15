package com.coletas.coletas.dao;

import java.util.Optional;

import com.coletas.coletas.model.Users;

	
public interface UserDAO extends BaseDAO<Users, Integer> {
	Optional<Users> getByDescription(String escritorio); 
}
