package com.coletas.coletas.dao.impl;

import org.springframework.stereotype.Repository;

import com.coletas.coletas.dao.BaseDAOImpl;
import com.coletas.coletas.dao.DeliveryTypeDAO;
import com.coletas.coletas.model.DeliveryType;

@Repository
public class DeliveryTypeDAOImpl extends BaseDAOImpl<DeliveryType, Integer> implements DeliveryTypeDAO{

	public DeliveryTypeDAOImpl() {
		super(DeliveryType.class);
	}

}
