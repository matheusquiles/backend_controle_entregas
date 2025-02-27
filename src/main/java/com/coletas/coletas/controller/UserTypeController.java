package com.coletas.coletas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coletas.coletas.model.UserType;
import com.coletas.coletas.service.impl.UserTypeServiceImpl;

@RestController
@RequestMapping("/api/userType")
public class UserTypeController extends BaseControllerImpl<UserType, Integer> {
	
	public UserTypeController(UserTypeServiceImpl service) {
		super(service);
	}

}
