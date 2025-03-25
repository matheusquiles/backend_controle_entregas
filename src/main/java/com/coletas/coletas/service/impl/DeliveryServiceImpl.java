package com.coletas.coletas.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coletas.coletas.dao.DeliveryDAO;
import com.coletas.coletas.dto.DeliveryDTO;
import com.coletas.coletas.dto.request.DeliveryRequestDTO;
import com.coletas.coletas.model.Delivery;
import com.coletas.coletas.service.DeliveryService;
import com.coletas.coletas.util.CreateKey;
import com.coletas.coletas.util.DeliveryStatus;

@Service
public class DeliveryServiceImpl extends BaseServiceImpl<Delivery, Integer> implements DeliveryService {

	@Autowired
	private DeliveryDAO dao;
	
	@Autowired
	private CreateKey key;
	

	@Override
	public void save(Delivery entity) {
		
		entity.setCreationDate(LocalDateTime.now());
		entity.setDeliveryKey(key.createDeliveryKey(entity));
		entity.setDeliveryStatus(DeliveryStatus.PENDENTE.getDescricao());
		dao.save(entity);
	}


	@Override
	public List<DeliveryDTO> getDTOByUserAndDate(DeliveryRequestDTO request) {
		return dao.getDTOByUserAndDate(request.getIdMotoboy(), request.getDeliveryStatus(), 
				request.getFinalDate(), request.getIdCoordinator(), request.getIdDeliveryRegion()
				, request.getInitialDate());
	}
}
