package com.coletas.coletas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coletas.coletas.dao.DeliveryDAO;
import com.coletas.coletas.model.Delivery;
import com.coletas.coletas.service.DeliveryService;

@Service
public class DeliveryServiceImpl extends BaseServiceImpl<Delivery, Integer> implements DeliveryService {

	@Autowired
	private DeliveryDAO dao;
	

	@Override
	public void save(Delivery entity) {
		dao.save(entity);
	}
}
