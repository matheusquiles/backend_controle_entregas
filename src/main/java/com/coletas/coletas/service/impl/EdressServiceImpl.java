package com.coletas.coletas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coletas.coletas.dao.CollectPreValueDAO;
import com.coletas.coletas.dao.EdressDAO;
import com.coletas.coletas.model.CollectPreValue;
import com.coletas.coletas.model.Edress;
import com.coletas.coletas.service.EdressService;

import jakarta.transaction.Transactional;

@Service
public class EdressServiceImpl extends BaseServiceImpl<Edress, Integer> implements EdressService {

	@Autowired
	private EdressDAO dao;
	
	@Autowired
	private CollectPreValueDAO cPVDAO;

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
	


}
