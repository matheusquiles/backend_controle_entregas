package com.coletas.coletas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coletas.coletas.dao.HierarchyDAO;
import com.coletas.coletas.model.Hierarchy;
import com.coletas.coletas.service.HierarchyService;

@Service
public class HierarchyServiceImpl extends BaseServiceImpl<Hierarchy, Integer> implements HierarchyService {

	@Autowired
	private HierarchyDAO dao;
	

	@Override
	public void save(Hierarchy entity) {
		dao.save(entity);

	}


}
