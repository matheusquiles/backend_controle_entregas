package com.coletas.coletas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coletas.coletas.model.DeliveryType;
import com.coletas.coletas.service.impl.DeliveryTypeServiceImpl;

@RestController
@RequestMapping("/api/deliveryType")
public class DeliveryTypeController extends BaseControllerImpl<DeliveryType, Integer> {
	
	public DeliveryTypeController(DeliveryTypeServiceImpl service) {
		super(service);
	}
	

}
