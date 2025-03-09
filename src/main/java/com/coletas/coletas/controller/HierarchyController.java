package com.coletas.coletas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coletas.coletas.model.Hierarchy;
import com.coletas.coletas.service.impl.HierarchyServiceImpl;

@RestController
@RequestMapping("/api/hierarchy")
public class HierarchyController extends BaseControllerImpl<Hierarchy, Integer> {
	
	
	public HierarchyController(HierarchyServiceImpl service) {
		super(service);
	}

}
