package com.coletas.coletas.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.coletas.coletas.dao.BaseDAOImpl;
import com.coletas.coletas.dao.CollectItensDAO;
import com.coletas.coletas.dto.CollectItensDTO;
import com.coletas.coletas.model.CollectItens;

@Repository
public class CollectItensDAOImpl extends BaseDAOImpl<CollectItens, Integer> implements CollectItensDAO {

	public CollectItensDAOImpl() {
		super(CollectItens.class);
	}

	@Override
	public List<CollectItens> serchByCollectId(Integer idCollect) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CollectItens> searchByCollectKey(String collectKey) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private StringBuilder searchDTO(String deliveryStatus) {

		StringBuilder hql = new StringBuilder();
		hql.append("select new com.coletas.coletas.dto.CollectItensDTO(");
		hql.append(" ct.description collectType");
		hql.append(", ci.quantity quantity");
		hql.append(", ci.deliveryStatus deliveryStatus");
		hql.append(", ci.valuePerUnitCollect valuePerUnitCollect");
		hql.append(", ci.totalToReceive totalToReceive");
		hql.append(", ci.valueToPayPerUnit valueToPayPerUnit");
		hql.append(", ci.totalValueToPay totalValueToPay");
		
		hql.append(" ) ");

		hql.append(" From CollectItens ci ");
		hql.append(" inner join ci.collectType ct ");
		
		hql.append(" where 1=1 ");
		
		if (deliveryStatus != null && !deliveryStatus.equals("todos")) {
		    hql.append(" and ci.deliveryStatus =:deliveryStatus ");
		}

		return hql;
	}

	@Override
	public List<CollectItensDTO> searchDTOByIdCollect(Integer idCollect, String deliveryStatus) {
		Session currentSession = entityManager.unwrap(Session.class);

		StringBuilder hql = searchDTO(deliveryStatus);
		hql.append(" and ci.collect.id = :idCollect ");
		
		
		Query<CollectItensDTO> list = currentSession.createQuery(hql.toString(), CollectItensDTO.class);
		list.setParameter("idCollect", idCollect);
		if (deliveryStatus != null && !deliveryStatus.equals("todos")) {
			list.setParameter("deliveryStatus", deliveryStatus);
		}
		List<CollectItensDTO> colletItens = list.getResultList();
		
		return colletItens.isEmpty() ? new ArrayList<>() : colletItens;
	}

	
}
