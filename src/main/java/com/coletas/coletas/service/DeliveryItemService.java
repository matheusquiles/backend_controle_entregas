package com.coletas.coletas.service;

import com.coletas.coletas.model.Delivery;
import com.coletas.coletas.model.DeliveryItems;

public interface DeliveryItemService extends BaseService<DeliveryItems, Integer> {
	
	DeliveryItems saveDeliveryItem(DeliveryItems entity);
	Boolean saveDeliveryItem(Delivery savedDelivery);

}
