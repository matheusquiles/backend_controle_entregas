package com.coletas.coletas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coletas.coletas.dao.DeliveryRegionDAO;
import com.coletas.coletas.model.DeliveryRegion;
import com.coletas.coletas.service.DeliveryRegionService;

@Service
public class DeliveryRegionServiceImpl extends BaseServiceImpl<DeliveryRegion, Integer> implements DeliveryRegionService {

	@Autowired
	private DeliveryRegionDAO dao;

	@Override
	public void save(DeliveryRegion entity) {
		dao.save(entity);
	}
	

}
