package com.coletas.coletas.dao.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.coletas.coletas.dao.BaseDAOImpl;
import com.coletas.coletas.dao.DeliveryDAO;
import com.coletas.coletas.dto.DeliveryDTO;
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

	@Override
	public List<DeliveryDTO> getDTOByUserAndDate(Integer idMotoboy, String deliveryStatus, LocalDate finalDate,
			Integer idCoordinator, Integer idDeliveryRegion, LocalDate initialDate) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		StringBuilder hql = searchDTO(idMotoboy, deliveryStatus, idCoordinator, idDeliveryRegion);
		
		Query<DeliveryDTO> query = currentSession.createQuery(hql.toString(), DeliveryDTO.class);
		query.setParameter("initialDate", initialDate);
		query.setParameter("finalDate", finalDate);
		
		if(idMotoboy!=null) {
			query.setParameter("idMotoboy", idMotoboy);
		}
		if(deliveryStatus != null) {
			query.setParameter("deliveryStatus", deliveryStatus);
			
		}
		if(idCoordinator!=null) {
			query.setParameter("idCoordinator", idCoordinator);
		}
		if(idDeliveryRegion!= null) {
			query.setParameter("idDeliveryRegion", idDeliveryRegion);
		}
		
		List<DeliveryDTO> resultList = query.getResultList();
		
		return resultList.isEmpty() ? new ArrayList<>() : resultList;
	}
	
	private StringBuilder searchDTO(Integer idMotoboy, String deliveryStatus, Integer idCoordinator, Integer idDeliveryRegion) {
		StringBuilder hql = new StringBuilder();
		hql.append("select new com.coletas.coletas.dto.DeliveryDTO(");
		hql.append("de.idDelivery idDelivery ");
		hql.append(", de.deliveryKey deliveryKey");
		hql.append(", de.value value");
		hql.append(", us.idUser idMotoboy");
		hql.append(", us.name nameMotoboy");
		hql.append(", co.idUser idCoordinator");
		hql.append(", co.name nameCoordinator");
		hql.append(", dr.idDeliveryRegion idDeliveryRegion");
		hql.append(", dr.deliveryRegion deliveryRegion");
		hql.append(", de.date date ");
		hql.append(", de.status status ");
		hql.append(", de.deliveryStatus deliveryStatus ");
		hql.append(" ) ");
		
		hql.append(" From Delivery de");
		hql.append(" inner join de.motoboy us ");
		hql.append(" inner join de.deliveryRegion dr ");
		hql.append(" left join Hierarchy hi on hi.motoboy.idUser = us.idUser ");
		hql.append(" left join hi.coordinator co ");
		
		hql.append(" where 1=1 ");

		hql.append(" and de.date >= :initialDate ");
		hql.append(" and de.date <= :finalDate ");
		
		if(idMotoboy!=null) {
			hql.append(" and us.idUser = :idMotoboy ");
		}
		if(deliveryStatus!= null ) {
			hql.append(" and de.deliveryStatus = :deliveryStatus ");
			
		}
		if(idCoordinator!=null) {
			hql.append(" and hi.coordinator.idUser = :idCoordinator ");
		}
		if(idDeliveryRegion!= null) {
			hql.append(" and dr.idDeliveryRegion = :idDeliveryRegion ");
		}
		
		return hql;
		
	}
	

}
