package com.coletas.coletas.dao.impl;

import org.springframework.stereotype.Repository;

import com.coletas.coletas.dao.BaseDAOImpl;
import com.coletas.coletas.dao.CollectTypeDAO;
import com.coletas.coletas.model.CollectType;

@Repository
public class CollectTypeDAOImpl extends BaseDAOImpl<CollectType, Integer> implements CollectTypeDAO {

	public CollectTypeDAOImpl() {
		super(CollectType.class);
	}
	

}
