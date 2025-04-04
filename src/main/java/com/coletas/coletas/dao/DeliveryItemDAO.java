package com.coletas.coletas.dao;

import com.coletas.coletas.model.Delivery;
import com.coletas.coletas.model.DeliveryItems;

public interface DeliveryItemDAO extends BaseDAO<DeliveryItems, Integer> {

	Boolean saveDeliveryItem(Delivery savedDelivery);

}
