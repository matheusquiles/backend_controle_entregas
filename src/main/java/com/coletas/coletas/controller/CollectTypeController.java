package com.coletas.coletas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coletas.coletas.model.CollectType;
import com.coletas.coletas.service.impl.CollectTypeServiceImpl;

@RestController
@RequestMapping("/api/collectType")
public class CollectTypeController extends BaseControllerImpl<CollectType, Integer> {
	
	public CollectTypeController(CollectTypeServiceImpl service) {
		super(service);
	}

}
