package com.coletas.coletas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coletas.coletas.dao.UserTypeDAO;
import com.coletas.coletas.model.UserType;
import com.coletas.coletas.service.UserTypeService;

import jakarta.transaction.Transactional;

@Service
public class UserTypeServiceImpl extends BaseServiceImpl<UserType, Integer> implements UserTypeService {
	
	@Autowired
	private UserTypeDAO dao;


	@Override
	@Transactional
	public void save(UserType entity) {
		dao.save(entity);
	}


}
