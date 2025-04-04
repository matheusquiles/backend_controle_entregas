package com.coletas.coletas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coletas.coletas.dao.DeliveryItemDAO;
import com.coletas.coletas.model.DeliveryItems;
import com.coletas.coletas.service.DeliveryItemService;

@Service
public class DeliveryItemServiceImpl extends BaseServiceImpl<DeliveryItems, Integer> implements DeliveryItemService {

	@Autowired
	private DeliveryItemDAO dao;
	
	
	@Override
	public void save(DeliveryItems entity) {
		dao.save(entity);
	}


	@Override
	public DeliveryItems saveDeliveryItem(DeliveryItems entity) {
		return dao.saveObject(entity);
	}



}
