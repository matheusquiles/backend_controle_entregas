package com.coletas.coletas.dao;

import java.time.LocalDate;
import java.util.List;

import com.coletas.coletas.dto.DeliveryDTO;
import com.coletas.coletas.dto.request.DeliveryRequestDTO;
import com.coletas.coletas.model.Delivery;

public interface DeliveryDAO extends BaseDAO<Delivery, Integer> {
	Integer countDeliveriesByUserAndDate(Integer idUser, LocalDate date);
	List<DeliveryDTO> getDTOByUserAndDate(Integer idMotoboy, String deliveryStatus, LocalDate finalDate,
			Integer idCoordinator, Integer idDeliveryRegion, LocalDate initialDate);

}
