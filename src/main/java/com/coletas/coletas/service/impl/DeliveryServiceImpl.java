package com.coletas.coletas.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coletas.coletas.dao.DeliveryDAO;
import com.coletas.coletas.dao.UserDAO;
import com.coletas.coletas.dto.DeliveryDTO;
import com.coletas.coletas.dto.request.DeliveryEditRequestDTO;
import com.coletas.coletas.dto.request.DeliveryRequestDTO;
import com.coletas.coletas.model.Delivery;
import com.coletas.coletas.model.Users;
import com.coletas.coletas.service.DeliveryService;
import com.coletas.coletas.util.CreateKey;
import com.coletas.coletas.util.DeliveryStatus;

import jakarta.transaction.Transactional;

@Service
public class DeliveryServiceImpl extends BaseServiceImpl<Delivery, Integer> implements DeliveryService {

	@Autowired
	private DeliveryDAO dao;

	@Autowired
	private CreateKey key;

	@Autowired
	private UserDAO userDAO;

	@Override
	public void save(Delivery entity) {

		entity.setCreationDate(LocalDateTime.now());
		entity.setDeliveryKey(key.createDeliveryKey(entity));
		entity.setDeliveryStatus(DeliveryStatus.PENDENTE.getDescricao());
		dao.save(entity);
	}

	@Override
	public List<DeliveryDTO> getDTOByUserAndDate(DeliveryRequestDTO request) {
		return dao.getDTOByUserAndDate(request.getIdMotoboy(), request.getDeliveryStatus(), request.getFinalDate(),
				request.getIdCoordinator(), request.getIdDeliveryRegion(), request.getInitialDate());
	}

	@Override
	@Transactional
	public Boolean editDelivery(List<DeliveryEditRequestDTO> request) {
		
		try {
			Users laster = userDAO.get(request.get(0).getLastModificationBy()).orElseThrow();

			for (DeliveryEditRequestDTO deliveryEditRequestDTO : request) {
				Delivery savedDelivery = dao.get(deliveryEditRequestDTO.getIdDelivery()).orElseThrow();
				
				//AGUARDANDO MODIFICAÇÃO DA DELIVERY REGION
				savedDelivery.setDeliveryStatus(deliveryEditRequestDTO.getDeliveryStatus());
				savedDelivery.setLastModificationBy(laster);
				savedDelivery.setValue(deliveryEditRequestDTO.getValue());
				savedDelivery.setLastModificationDate(LocalDateTime.now());
				
				dao.save(savedDelivery);
			}
			
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
}
