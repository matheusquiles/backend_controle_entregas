package com.coletas.coletas.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.coletas.coletas.dao.BaseDAOImpl;
import com.coletas.coletas.dao.DeliveryItemDAO;
import com.coletas.coletas.dto.DeliveryItemsDTO;
import com.coletas.coletas.model.Delivery;
import com.coletas.coletas.model.DeliveryItems;

@Repository
public class DeliveryItemDAOImpl extends BaseDAOImpl<DeliveryItems, Integer> implements DeliveryItemDAO {

	public DeliveryItemDAOImpl() {
		super(DeliveryItems.class);
	}

	@Override
	public Boolean saveDeliveryItem(Delivery savedDelivery) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DeliveryItemsDTO> searchDTOByDelivery(Integer idDelivery, String deliveryStatus) {
		Session currentSession = entityManager.unwrap(Session.class);

		StringBuilder hql = searchDTO(deliveryStatus);
		hql.append(" and de.idDelivery = :idDelivery ");
		
		
		Query<DeliveryItemsDTO> list = currentSession.createQuery(hql.toString(), DeliveryItemsDTO.class);
		list.setParameter("idDelivery", idDelivery);
		if (deliveryStatus != null && !deliveryStatus.equals("todos")) {
			list.setParameter("deliveryStatus", deliveryStatus);
		}
		List<DeliveryItemsDTO> colletItens = list.getResultList();
		
		return colletItens.isEmpty() ? new ArrayList<>() : colletItens;
	}
	
	
	private StringBuilder searchDTO(String deliveryStatus) {

		StringBuilder hql = new StringBuilder();
		hql.append("select new com.coletas.coletas.dto.DeliveryItemsDTO(");
		hql.append(" di.idDeliveryItems idDeliveryItems");
		hql.append(", de.idDelivery idDelivery");
		hql.append(", de.deliveryKey deliveryKey");
		hql.append(", dt.idDeliveryType idDeliveryType");
		hql.append(", dt.description deliveryType");
		hql.append(", di.quantity quantity");
		hql.append(", di.deliveryStatus deliveryStatus");
		hql.append(", di.valuePerUnitDelivery valuePerUnitDelivery");
		
		hql.append(" ) ");

		hql.append(" From DeliveryItems di ");
		hql.append(" inner join di.delivery de ");
		hql.append(" inner join di.deliveryType dt ");
		
		hql.append(" where 1=1 ");
		
		if (deliveryStatus != null && !deliveryStatus.equals("todos")) {
		    hql.append(" and di.deliveryStatus =:deliveryStatus ");
		}

		return hql;
	}
}
