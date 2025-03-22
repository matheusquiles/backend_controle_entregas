package com.coletas.coletas.dao.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.coletas.coletas.dao.BaseDAOImpl;
import com.coletas.coletas.dao.CollectPreValueDAO;
import com.coletas.coletas.dto.CollectPreValueDTO;
import com.coletas.coletas.model.CollectPreValue;

@Repository
public class CollectPreValueDAOImpl extends BaseDAOImpl<CollectPreValue, Integer> implements CollectPreValueDAO {

	public CollectPreValueDAOImpl() {
		super(CollectPreValue.class);
	}

	@Override
	public List<CollectPreValueDTO> getByAddresses(List<Integer> idAddresses) {
	    if (idAddresses == null || idAddresses.isEmpty()) {
	        return Collections.emptyList();
	    }

	    Session currentSession = entityManager.unwrap(Session.class);
	    String hql = "FROM CollectPreValue cpv WHERE cpv.edress.idEdress IN :idAddresses";

	    Query<CollectPreValue> query = currentSession.createQuery(hql, CollectPreValue.class);
	    query.setParameter("idAddresses", idAddresses);
	    List<CollectPreValue> resultList = query.getResultList();

	    return resultList.stream().map(cpv -> {
	        CollectPreValueDTO dto = new CollectPreValueDTO();
	        dto.setIdCollectPreValue(cpv.getIdCollectPreValue());
	        dto.setIdEdress(cpv.getEdress().getIdEdress());
	        dto.setEdress(cpv.getEdress().getEdress());
	        dto.setIdCollectType(cpv.getCollectType().getIdCollectType());
	        dto.setCollectType(cpv.getCollectType().getDescription());
	        dto.setPreValue(cpv.getPreValue());
	        return dto;
	    }).collect(Collectors.toList());
	}
}
