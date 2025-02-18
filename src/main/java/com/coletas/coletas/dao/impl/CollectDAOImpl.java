package com.coletas.coletas.dao.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.coletas.coletas.dao.BaseDAOImpl;
import com.coletas.coletas.dao.CollectDAO;
import com.coletas.coletas.model.Collect;

@Repository
public class CollectDAOImpl extends BaseDAOImpl<Collect, Integer> implements CollectDAO {

	public CollectDAOImpl() {
		super(Collect.class);
	}

	@Override
	public List<Collect> getByUserKeyAndDate(String userKey, LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Collect> getByUserKeyAndDate(String userKey) {
		// TODO Auto-generated method stub
		return null;
	}


}
