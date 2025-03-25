package com.coletas.coletas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coletas.coletas.dto.DeliveryDTO;
import com.coletas.coletas.dto.request.DeliveryEditRequestDTO;
import com.coletas.coletas.dto.request.DeliveryRequestDTO;
import com.coletas.coletas.model.Delivery;
import com.coletas.coletas.service.DeliveryService;
import com.coletas.coletas.service.impl.DeliveryServiceImpl;

@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController extends BaseControllerImpl<Delivery, Integer> {

	@Autowired
	private DeliveryService service;

	public DeliveryController(DeliveryServiceImpl service) {
		super(service);
	}

	@PostMapping("/getDTO")
	public List<DeliveryDTO> getDTOByUserAndDate(@RequestBody DeliveryRequestDTO request) {

		try {
			List<DeliveryDTO> list = service.getDTOByUserAndDate(request);
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@PostMapping("/editDelivery")
	public Boolean editDelivery(@RequestBody List<DeliveryEditRequestDTO> request) {
		try {
			return service.editDelivery(request);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
