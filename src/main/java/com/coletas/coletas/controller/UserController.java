package com.coletas.coletas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coletas.coletas.model.Users;
import com.coletas.coletas.service.SecurityUserService;
import com.coletas.coletas.service.UserService;
import com.coletas.coletas.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/api/users")
public class UserController extends BaseControllerImpl<Users, Integer> {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private SecurityUserService securityUserService;
	
	public UserController(UserServiceImpl service) {
		super(service);
	}
	
	@Override
	public Boolean save(Users user) {
		
		if(service.searchUser(user.getUserKey())) {
			System.err.println("User already exists: " + user.getUserKey());
			return false;
		}
		
		try {
			if(service.saveUser(user)) {
				securityUserService.save(user);
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			throw new RuntimeException("Failed to save user: " + user.getUserKey(), e);
		}
		
		
	}

}
