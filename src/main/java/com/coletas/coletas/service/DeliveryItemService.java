package com.coletas.coletas.service;

import com.coletas.coletas.model.DeliveryItems;

public interface DeliveryItemService extends BaseService<DeliveryItems, Integer> {
	
	DeliveryItems saveDeliveryItem(DeliveryItems entity);

}
