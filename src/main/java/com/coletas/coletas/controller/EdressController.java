package com.coletas.coletas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coletas.coletas.model.Edress;
import com.coletas.coletas.service.impl.EdressServiceImpl;

@RestController
@RequestMapping("/api/edress")
public class EdressController extends BaseControllerImpl<Edress, Integer> {
	
	
	public EdressController(EdressServiceImpl service) {
		super(service);
	}


}
