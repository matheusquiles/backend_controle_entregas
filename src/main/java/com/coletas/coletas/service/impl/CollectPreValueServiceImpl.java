package com.coletas.coletas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coletas.coletas.dao.CollectPreValueDAO;
import com.coletas.coletas.model.CollectPreValue;
import com.coletas.coletas.service.CollectPreValueService;

@Service
public class CollectPreValueServiceImpl extends BaseServiceImpl<CollectPreValue, Integer>
		implements CollectPreValueService {

	@Autowired
	private CollectPreValueDAO dao;
	
	
	@Override
	public void save(CollectPreValue entity) {
		dao.save(entity);
	}
	
	
	

}
