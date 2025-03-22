package com.coletas.coletas.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coletas.coletas.dao.BaseDAOImpl;
import com.coletas.coletas.dao.CollectPreValueDAO;
import com.coletas.coletas.dao.EdressDAO;
import com.coletas.coletas.dto.AddressDTO;
import com.coletas.coletas.dto.CollectPreValueDTO;
import com.coletas.coletas.dto.request.AddressRequest;
import com.coletas.coletas.model.Edress;

@Repository
public class EdressDAOImpl extends BaseDAOImpl<Edress, Integer> implements EdressDAO {

	public EdressDAOImpl() {
		super(Edress.class);
	}
	
	@Autowired
	private CollectPreValueDAO collectPreValueDAO;

	@Override
	public Optional<Edress> getByDescription(String description) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Double getPreValue(Integer idEdress, Integer idCollectType) {
	    Session currentSession = entityManager.unwrap(Session.class);
	    StringBuilder hql = searchDTO();
	    hql.append(" and edr.idEdress = :idEdress ");
	    hql.append(" and clt.idCollectType = :idCollectType ");

	    try {
	        CollectPreValueDTO dto = currentSession.createQuery(hql.toString(), CollectPreValueDTO.class)
	                .setParameter("idEdress", idEdress)
	                .setParameter("idCollectType", idCollectType)
	                .uniqueResult();

	        return dto != null ? dto.getPreValue() : 0.0;
	    } catch (Exception e) {
	        System.err.println("Erro ao executar query: " + e.getMessage());
	        e.printStackTrace();
	        return 0.0;
	    }
	}

	private StringBuilder searchDTO() {
		StringBuilder hql = new StringBuilder();

		hql.append("select new com.coletas.coletas.dto.CollectPreValueDTO(");
		hql.append(" cpv.idCollectPreValue ");
		hql.append(", edr.idEdress ");
		hql.append(", edr.edress ");
		hql.append(", clt.idCollectType ");
		hql.append(", clt.description ");
		hql.append(", cpv.preValue ");
		hql.append(" ) ");

		hql.append("from CollectPreValue cpv ");
		hql.append("inner join cpv.edress edr ");
		hql.append("inner join cpv.collectType clt ");

		hql.append("where 1 = 1");

		return hql;
	}

	public List<AddressDTO> getByFilters(AddressRequest address) {
	    Session currentSession = entityManager.unwrap(Session.class);
	    StringBuilder hql = new StringBuilder("SELECT edr FROM Edress edr WHERE 1 = 1");

	    Map<String, Object> parameters = new HashMap<>();

	    if (address != null) {
	        if (address.getEdress() != null && !address.getEdress().isEmpty()) {
	            String edressValue = address.getEdress().replace("*", "%").toLowerCase();
	            hql.append(" AND LOWER(edr.edress) LIKE :edress");
	            parameters.put("edress", edressValue);
	        }
	        if (address.getDescription() != null && !address.getDescription().isEmpty()) {
	            String descriptionValue = address.getDescription().replace("*", "%").toLowerCase();
	            hql.append(" AND LOWER(edr.description) LIKE :description");
	            parameters.put("description", descriptionValue);
	        }
	        if (address.getStatus() != null) {
	            hql.append(" AND edr.status = :status");
	            parameters.put("status", address.getStatus());
	        }
	    }

	    Query<Edress> query = currentSession.createQuery(hql.toString(), Edress.class);
	    parameters.forEach(query::setParameter);

	    List<Edress> resultList = query.getResultList();

	    List<AddressDTO> addressDTOs = new ArrayList<>();
	    if (!resultList.isEmpty()) {
	        List<Integer> idEdresses = resultList.stream()
	                .map(Edress::getIdEdress)
	                .collect(Collectors.toList());
	        List<CollectPreValueDTO> allCpvDTOs = collectPreValueDAO.getByAddresses(idEdresses);

	        Map<Integer, List<CollectPreValueDTO>> cpvByEdress = allCpvDTOs.stream()
	                .collect(Collectors.groupingBy(CollectPreValueDTO::getIdEdress));

	        for (Edress edress : resultList) {
	            AddressDTO dto = new AddressDTO();
	            dto.setIdEdress(edress.getIdEdress());
	            dto.setDescription(edress.getDescription());
	            dto.setEdress(edress.getEdress());
	            dto.setStatus(edress.getStatus());

	            List<CollectPreValueDTO> cpvDTOs = cpvByEdress.getOrDefault(edress.getIdEdress(), Collections.emptyList());
	            dto.setCollectPreValue(cpvDTOs);

	            addressDTOs.add(dto);
	        }
	    }

	    return addressDTOs;
	}

}
