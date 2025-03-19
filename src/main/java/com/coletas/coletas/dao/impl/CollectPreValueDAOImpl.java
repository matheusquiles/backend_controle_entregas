package com.coletas.coletas.dao.impl;

import org.springframework.stereotype.Repository;

import com.coletas.coletas.dao.BaseDAOImpl;
import com.coletas.coletas.dao.CollectPreValueDAO;
import com.coletas.coletas.model.CollectPreValue;

@Repository
public class CollectPreValueDAOImpl extends BaseDAOImpl<CollectPreValue, Integer> implements CollectPreValueDAO {

	public CollectPreValueDAOImpl() {
		super(CollectPreValue.class);
	}
	

}
