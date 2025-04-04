package com.coletas.coletas.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coletas.coletas.dao.DeliveryItemDAO;
import com.coletas.coletas.model.Delivery;
import com.coletas.coletas.model.DeliveryItems;
import com.coletas.coletas.service.DeliveryItemService;
import com.coletas.coletas.util.DeliveryStatus;

import jakarta.transaction.Transactional;

@Service
public class DeliveryItemServiceImpl extends BaseServiceImpl<DeliveryItems, Integer> implements DeliveryItemService {

	@Autowired
	private DeliveryItemDAO dao;

	@Override
	public void save(DeliveryItems entity) {
		dao.save(entity);
	}

	@Override
	public DeliveryItems saveDeliveryItem(DeliveryItems entity) {
		return dao.saveObject(entity);
	}

	@Override
	@Transactional
	public Boolean saveDeliveryItem(Delivery savedDelivery) {

		if (!savedDelivery.getDeliveryItems().isEmpty()) {
			for (DeliveryItems deliveryItem : savedDelivery.getDeliveryItems()) {
				deliveryItem.setDelivery(savedDelivery);
				deliveryItem.setCreationDate(LocalDateTime.now());
				deliveryItem.setCreatedBy(savedDelivery.getCreatedBy());
				deliveryItem.setTotalToPay(deliveryItem.getValuePerUnitDelivery() * deliveryItem.getQuantity());
				deliveryItem.setDeliveryStatus(DeliveryStatus.PENDENTE.getDescricao());

				try {
					dao.save(deliveryItem);
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			}
			return true;
		}
		return false;

	}

}
