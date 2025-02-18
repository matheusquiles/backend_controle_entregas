package com.coletas.coletas.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coletas.coletas.dao.CollectDAO;
import com.coletas.coletas.model.Collect;
import com.coletas.coletas.model.Users;
import com.coletas.coletas.service.CollectService;

import jakarta.transaction.Transactional;

@Service
public class CollectServiceImpl extends BaseServiceImpl<Collect, Integer> implements CollectService {
	
	@Autowired
	private CollectDAO dao;
	

	@Transactional
	@Override
	public Boolean saveCollect(Collect entity) {
		try {
			entity.setCreationDate(LocalDateTime.now());
			entity.setCreatedBy(new Users(5)); //adicionado para testes
			dao.save(entity);
			
			return true;
		} catch (Exception e) {
			throw new RuntimeException("Failed to save collect: " + entity.getIdCollect(), e);
		}
	}


	@Transactional
	@Override
	public void save(Collect entity) {
		dao.save(entity);
		
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
