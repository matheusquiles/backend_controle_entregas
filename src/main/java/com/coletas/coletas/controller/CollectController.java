package com.coletas.coletas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coletas.coletas.model.Collect;
import com.coletas.coletas.service.CollectService;
import com.coletas.coletas.service.impl.CollectServiceImpl;

@RestController
@RequestMapping("/api/collects")
public class CollectController extends BaseControllerImpl<Collect, Integer> {

	@Autowired
	private CollectService service;
	
	
	public CollectController(CollectServiceImpl service) {
		super(service);
	}
	
	@Override
	public Boolean save(Collect entity) {
		
		try {
			if(service.saveCollect(entity)) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			throw new RuntimeException("Failed to save collect: " + entity.getIdCollect(), e);
		}
		
	}

}
