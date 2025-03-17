package com.coletas.coletas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coletas.coletas.model.DeliveryRegion;
import com.coletas.coletas.service.impl.DeliveryRegionServiceImpl;

@RestController
@RequestMapping("/api/deliveryRegion")
public class DeliveryRegionController extends BaseControllerImpl<DeliveryRegion, Integer>{

	public DeliveryRegionController(DeliveryRegionServiceImpl service) {
		super(service);
	}
}
