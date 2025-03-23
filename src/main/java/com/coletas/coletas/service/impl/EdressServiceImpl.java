package com.coletas.coletas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coletas.coletas.dao.CollectPreValueDAO;
import com.coletas.coletas.dao.CollectTypeDAO;
import com.coletas.coletas.dao.EdressDAO;
import com.coletas.coletas.dto.AddressDTO;
import com.coletas.coletas.dto.CollectPreValueDTO;
import com.coletas.coletas.dto.request.AddressRequest;
import com.coletas.coletas.model.CollectPreValue;
import com.coletas.coletas.model.CollectType;
import com.coletas.coletas.model.Edress;
import com.coletas.coletas.service.EdressService;

import jakarta.transaction.Transactional;

@Service
public class EdressServiceImpl extends BaseServiceImpl<Edress, Integer> implements EdressService {

	@Autowired
	private EdressDAO dao;
	
	@Autowired
	private CollectPreValueDAO cPVDAO;
	
	@Autowired
	private CollectTypeDAO collectTypeDAO;

	@Override
	@Transactional
	public void save(Edress entity) {
		try {
			Edress saved = dao.saveObject(entity);
			
			for (CollectPreValue c : entity.getCollectPreValue()) {
				c.setEdress(saved);
				cPVDAO.save(c);
			}
			
		} catch (Exception e) {
			throw new RuntimeException("Failed to save edress: " + entity.getDescription(), e);
			
		}
		
		
	}

	@Override
	@Transactional
	public List<AddressDTO> getByFilters(AddressRequest address) {
		return dao.getByFilters(address);
	}

	
	
	@Override
	@Transactional
	public Boolean editAddress(List<AddressDTO> addresses) {
	    try {
	        for (AddressDTO addressDTO : addresses) {
	            Edress edress = new Edress();
	            edress.setIdEdress(addressDTO.getIdEdress());
	            edress.setDescription(addressDTO.getDescription());
	            edress.setEdress(addressDTO.getEdress());
	            edress.setStatus(addressDTO.getStatus());

	            dao.save(edress);

	            List<CollectPreValueDTO> collectPreValues = addressDTO.getCollectPreValue();
	            if (collectPreValues != null && !collectPreValues.isEmpty()) {
	                for (CollectPreValueDTO cpvDTO : collectPreValues) {
	                    CollectPreValue cpv = new CollectPreValue();
	                    cpv.setIdCollectPreValue(cpvDTO.getIdCollectPreValue()); 
	                    cpv.setEdress(edress); 
	                    cpv.setPreValue(cpvDTO.getPreValue());

	                    CollectType collectType = collectTypeDAO.get(cpvDTO.getIdCollectType())
	                            .orElseThrow(() -> new IllegalArgumentException("CollectType não encontrado para id: " + cpvDTO.getIdCollectType()));
	                    cpv.setCollectType(collectType);

	                    cPVDAO.save(cpv);
	                }
	            }
	        }
	        return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	


}
