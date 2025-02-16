package com.coletas.coletas.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coletas.coletas.dao.UserDAO;
import com.coletas.coletas.model.Users;
import com.coletas.coletas.service.UserService;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl extends BaseServiceImpl<Users, Integer> implements UserService{
	
	@Autowired
	private UserDAO dao;
	
	@Transactional
	@Override
	public void save(Users entity) {
		if(dao.getByDescription(entity.getUserKey()).isEmpty()){
			entity.setCreationDate(LocalDateTime.now());
			dao.save(entity);
		}  else {
	        throw new RuntimeException("User " + entity.getUserKey() + " already exists");
	    }		
	}

}
