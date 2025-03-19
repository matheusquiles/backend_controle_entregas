package com.coletas.coletas.dao.impl;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.coletas.coletas.dao.BaseDAOImpl;
import com.coletas.coletas.dao.EdressDAO;
import com.coletas.coletas.model.Edress;

@Repository
public class EdressDAOImpl extends BaseDAOImpl<Edress, Integer> implements EdressDAO {

	public EdressDAOImpl() {
		super(Edress.class);
	}
	
	@Override
	public Optional<Edress> getByDescription(String description) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
	
	

}
