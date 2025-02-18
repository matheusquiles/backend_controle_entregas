package com.coletas.coletas.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.coletas.coletas.dao.BaseDAOImpl;
import com.coletas.coletas.dao.CollectItensDAO;
import com.coletas.coletas.model.CollectItens;

@Repository
public class CollectItensDAOImpl extends BaseDAOImpl<CollectItens, Integer> implements CollectItensDAO {

	public CollectItensDAOImpl() {
		super(CollectItens.class);
	}

	@Override
	public List<CollectItens> serchByCollectId(Integer idCollect) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
