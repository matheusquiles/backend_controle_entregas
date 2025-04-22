package com.coletas.coletas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coletas.coletas.dto.CollectReportDTO;
import com.coletas.coletas.dto.DeliveryDTO;
import com.coletas.coletas.dto.DeliveryReportDTO;
import com.coletas.coletas.dto.ReportRequestDTO;
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
	
	@Override
	public Boolean save(Delivery delivery){
		try {
			service.saveDelivery(delivery);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
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
	
	@PostMapping("/batch")
	public ResponseEntity<Delivery> createCollectBatch(@RequestBody List<Delivery> deliveries) {

		try {
			for (Delivery delivery : deliveries) {
				service.saveDelivery(delivery);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/report/deliveries")
	public ResponseEntity<DeliveryReportDTO> collectsByDay(@RequestBody ReportRequestDTO report) {

		try {	
			DeliveryReportDTO result = service.deliveriesByDay(report);
			return ResponseEntity.ok(result);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

}
