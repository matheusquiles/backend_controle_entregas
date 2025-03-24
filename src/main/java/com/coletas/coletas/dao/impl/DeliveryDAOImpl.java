package com.coletas.coletas.dao.impl;

import java.time.LocalDate;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.coletas.coletas.dao.BaseDAOImpl;
import com.coletas.coletas.dao.DeliveryDAO;
import com.coletas.coletas.model.Delivery;

@Repository
public class DeliveryDAOImpl extends BaseDAOImpl<Delivery, Integer> implements DeliveryDAO {

	public DeliveryDAOImpl() {
		super(Delivery.class);
	}

	@Override
	public Integer countDeliveriesByUserAndDate(Integer idUser, LocalDate date) {
		Session currentSession = entityManager.unwrap(Session.class);
		StringBuilder hql = new StringBuilder();
		hql.append("select count(de.idDelivery) ");
		hql.append("from Delivery de ");
		hql.append("inner join de.motoboy mo ");
		hql.append("where de.date = :date ");
		hql.append("and mo.idUser = :idUser ");

		Query<Long> query = currentSession.createQuery(hql.toString(), Long.class);
		query.setParameter("date", date);
		query.setParameter("idUser", idUser);

		Optional<Long> result = query.uniqueResultOptional();
		return result.map(Long::intValue).orElse(0);
	}
	
	

}
