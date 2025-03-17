package com.coletas.coletas.dao.impl;

import org.springframework.stereotype.Repository;

import com.coletas.coletas.dao.BaseDAOImpl;
import com.coletas.coletas.dao.DeliveryRegionDAO;
import com.coletas.coletas.model.DeliveryRegion;

@Repository
public class DeliveryRegionDAOImpl extends BaseDAOImpl<DeliveryRegion, Integer> implements DeliveryRegionDAO {

	public DeliveryRegionDAOImpl() {
		super(DeliveryRegion.class);
	}
	

}
