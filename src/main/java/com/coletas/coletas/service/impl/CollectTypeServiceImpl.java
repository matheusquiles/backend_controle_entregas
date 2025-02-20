package com.coletas.coletas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coletas.coletas.dao.CollectTypeDAO;
import com.coletas.coletas.model.CollectType;
import com.coletas.coletas.service.CollectTypeService;

import jakarta.transaction.Transactional;

@Service
public class CollectTypeServiceImpl extends BaseServiceImpl<CollectType, Integer> implements CollectTypeService {

	@Autowired
	private CollectTypeDAO dao;
	

	@Override
	@Transactional
	public void save(CollectType entity) {
		dao.save(entity);

	}


}
