package com.coletas.coletas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coletas.coletas.model.DeliveryItems;
import com.coletas.coletas.service.impl.DeliveryItemServiceImpl;

@RestController
@RequestMapping("/api/deliveryItem")
public class DeliveryItemController extends BaseControllerImpl<DeliveryItems, Integer> {
	
	public DeliveryItemController(DeliveryItemServiceImpl service) {
		super(service);
	}

}
