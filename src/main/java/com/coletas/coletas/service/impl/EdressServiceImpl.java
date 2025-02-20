package com.coletas.coletas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coletas.coletas.dao.EdressDAO;
import com.coletas.coletas.model.Edress;
import com.coletas.coletas.service.EdressService;

import jakarta.transaction.Transactional;

@Service
public class EdressServiceImpl extends BaseServiceImpl<Edress, Integer> implements EdressService {

	@Autowired
	private EdressDAO dao;

	@Override
	@Transactional
	public void save(Edress entity) {
		dao.save(entity);
		
	}
	


}
