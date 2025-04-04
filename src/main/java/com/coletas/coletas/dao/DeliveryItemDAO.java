package com.coletas.coletas.dao;

import java.util.List;

import com.coletas.coletas.dto.DeliveryItemsDTO;
import com.coletas.coletas.model.Delivery;
import com.coletas.coletas.model.DeliveryItems;

public interface DeliveryItemDAO extends BaseDAO<DeliveryItems, Integer> {

	Boolean saveDeliveryItem(Delivery savedDelivery);
	List<DeliveryItemsDTO> searchDTOByDelivery(Integer idDelivery, String deliveryStatus);

}
