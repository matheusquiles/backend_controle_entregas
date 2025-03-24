package com.coletas.coletas.dao;

import java.time.LocalDate;

import com.coletas.coletas.model.Delivery;

public interface DeliveryDAO extends BaseDAO<Delivery, Integer> {
	Integer countDeliveriesByUserAndDate(Integer idUser, LocalDate date);

}
