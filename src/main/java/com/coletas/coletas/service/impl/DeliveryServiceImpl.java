package com.coletas.coletas.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coletas.coletas.dao.DeliveryDAO;
import com.coletas.coletas.model.Delivery;
import com.coletas.coletas.service.DeliveryService;
import com.coletas.coletas.util.CreateKey;

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
		dao.save(entity);
	}
}
