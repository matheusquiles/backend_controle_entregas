package com.coletas.coletas.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coletas.coletas.dao.CollectDAO;
import com.coletas.coletas.dto.CollectDTO;
import com.coletas.coletas.model.Collect;
import com.coletas.coletas.service.CollectService;
import com.coletas.coletas.util.CreateKey;

import jakarta.transaction.Transactional;

@Service
public class CollectServiceImpl extends BaseServiceImpl<Collect, Integer> implements CollectService {
	
	@Autowired
	private CollectDAO dao;
	
	@Autowired
	private CreateKey key;
	
	@Transactional
	@Override
	public Collect saveCollect(Collect entity) {
		try {
			entity.setCreationDate(LocalDateTime.now());
			entity.setCollectKey(key.createKey(entity));
			dao.save(entity);
			
			return entity;
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


	@Override
	public List<CollectDTO> getDTOByUserAndDate(Integer idUser, LocalDate initialDate, LocalDate finalDate, Integer idSupervidor, Integer idEdress, String deliveryStatus) {
		return dao.getDTOByUserAndDate(idUser, initialDate, finalDate, idSupervidor, idEdress, deliveryStatus);
	}
	
//	public String createKey(Collect entity) {
//		try {
//			LocalDate date = entity.getDate();
//
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
//			String formattedDate = date.format(formatter);
//
//			Integer userId = entity.getUserId().getIdUser();
//
//			Integer qtdCollects = dao.countCollectByUserAndDate(userId, date) +1;
//
//			return formattedDate + userId + qtdCollects;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}

}
