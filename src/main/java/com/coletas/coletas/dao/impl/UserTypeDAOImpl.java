package com.coletas.coletas.dao.impl;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.coletas.coletas.dao.BaseDAOImpl;
import com.coletas.coletas.dao.UserTypeDAO;
import com.coletas.coletas.model.UserType;

@Repository
public class UserTypeDAOImpl extends BaseDAOImpl<UserType, Integer> implements UserTypeDAO {

	
	public UserTypeDAOImpl() {
		super(UserType.class);
	}

	@Override
	public Optional<UserType> getByDescription(String description) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
