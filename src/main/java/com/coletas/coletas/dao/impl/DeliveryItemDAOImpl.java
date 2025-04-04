package com.coletas.coletas.dao.impl;

import org.springframework.stereotype.Repository;

import com.coletas.coletas.dao.BaseDAOImpl;
import com.coletas.coletas.dao.DeliveryItemDAO;
import com.coletas.coletas.model.DeliveryItems;

@Repository
public class DeliveryItemDAOImpl extends BaseDAOImpl<DeliveryItems, Integer> implements DeliveryItemDAO {

	public DeliveryItemDAOImpl() {
		super(DeliveryItems.class);
	}
}
