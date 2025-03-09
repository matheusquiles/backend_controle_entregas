package com.coletas.coletas.dao.impl;

import org.springframework.stereotype.Repository;

import com.coletas.coletas.dao.BaseDAOImpl;
import com.coletas.coletas.dao.HierarchyDAO;
import com.coletas.coletas.model.Hierarchy;

@Repository
public class HierarchyDAOImpl extends BaseDAOImpl<Hierarchy, Integer> implements HierarchyDAO {
	
	public HierarchyDAOImpl() {
		super(Hierarchy.class);
	}


}
