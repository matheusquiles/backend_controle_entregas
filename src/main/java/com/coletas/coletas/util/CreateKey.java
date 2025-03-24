package com.coletas.coletas.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coletas.coletas.dao.CollectDAO;
import com.coletas.coletas.dao.DeliveryDAO;
import com.coletas.coletas.model.Collect;
import com.coletas.coletas.model.Delivery;

@Service
public class CreateKey {
	
	@Autowired
	private CollectDAO collectDAO;
	
	@Autowired
	private DeliveryDAO deliveryDAO;
	
	public String createCollectKey(Collect entity) {
		try {
			LocalDate date = entity.getDate();

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
			String formattedDate = date.format(formatter);

			Integer userId = entity.getUserId().getIdUser();

			Integer qtdCollects = collectDAO.countCollectByUserAndDate(userId, date) +1;

			return "C" +formattedDate + userId + String.format("%03d",qtdCollects);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String createDeliveryKey(Delivery entity) {
	    try {
	        LocalDate date = entity.getDate(); 

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
	        String formattedDate = date.format(formatter);

	        Integer userId = entity.getCreatedBy().getIdUser(); 

	        Integer qtdDeliveries = deliveryDAO.countDeliveriesByUserAndDate(userId, date) + 1; 

	        return "D" + formattedDate + userId + String.format("%03d", qtdDeliveries);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
}
