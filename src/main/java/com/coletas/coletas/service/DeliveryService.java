package com.coletas.coletas.service;

import java.util.List;

import com.coletas.coletas.dto.DeliveryDTO;
import com.coletas.coletas.dto.request.DeliveryEditRequestDTO;
import com.coletas.coletas.dto.request.DeliveryRequestDTO;
import com.coletas.coletas.model.Delivery;

public interface DeliveryService extends BaseService<Delivery, Integer> {

	List<DeliveryDTO> getDTOByUserAndDate(DeliveryRequestDTO request);
	Boolean editDelivery(List<DeliveryEditRequestDTO> dto);

}
