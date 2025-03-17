package com.coletas.coletas.dao.impl;

import org.springframework.stereotype.Repository;

import com.coletas.coletas.dao.BaseDAOImpl;
import com.coletas.coletas.dao.DeliveryDAO;
import com.coletas.coletas.model.Delivery;

@Repository
public class DeliveryDAOImpl extends BaseDAOImpl<Delivery, Integer> implements DeliveryDAO {

	public DeliveryDAOImpl() {
		super(Delivery.class);
	}
	
	

}
