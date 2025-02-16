package com.coletas.coletas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coletas.coletas.model.Users;
import com.coletas.coletas.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/api/users")
public class UserController extends BaseControllerImpl<Users, Integer> {
	
	public UserController(UserServiceImpl service) {
		super(service);
	}

}
