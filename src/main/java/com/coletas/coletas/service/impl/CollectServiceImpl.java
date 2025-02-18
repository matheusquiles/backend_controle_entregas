package com.coletas.coletas.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
			entity.setCollectKey(createKey(entity));
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


	@Override
	public Integer countCollectByUserAndDate(Integer userId, LocalDate date) {
		try {
			Integer result = dao.countCollectByUserAndDate(userId, date);
			return ++result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String createKey(Collect entity) {
		try {
			LocalDate date = entity.getDate();

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
			String formattedDate = date.format(formatter);

			Integer userId = entity.getUserId().getIdUser();

			Integer qtdCollects = countCollectByUserAndDate(userId, date);

			return formattedDate + userId + qtdCollects;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
