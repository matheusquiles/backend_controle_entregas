package com.coletas.coletas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coletas.coletas.model.Delivery;
import com.coletas.coletas.service.impl.DeliveryServiceImpl;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryController extends BaseControllerImpl<Delivery, Integer> {
	
	public DeliveryController(DeliveryServiceImpl service) {
		super(service);
	}

}
