package com.coletas.coletas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coletas.coletas.dao.DeliveryTypeDAO;
import com.coletas.coletas.model.DeliveryType;
import com.coletas.coletas.service.DeliveryTypeService;

import jakarta.transaction.Transactional;

@Service
public class DeliveryTypeServiceImpl extends BaseServiceImpl<DeliveryType, Integer >implements DeliveryTypeService {

	@Autowired
	private DeliveryTypeDAO dao;
	
	
	@Override
	@Transactional
	public void save(DeliveryType entity) {
		dao.save(entity);
	}


}
