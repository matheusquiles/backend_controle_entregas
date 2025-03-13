package com.coletas.coletas.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coletas.coletas.dao.CollectDAO;
import com.coletas.coletas.dao.CollectItensDAO;
import com.coletas.coletas.dao.UserDAO;
import com.coletas.coletas.dto.CollectDTO;
import com.coletas.coletas.dto.CollectItensDTO;
import com.coletas.coletas.dto.request.CollectEditRequestDTO;
import com.coletas.coletas.model.Collect;
import com.coletas.coletas.model.CollectItens;
import com.coletas.coletas.model.Users;
import com.coletas.coletas.service.CollectService;
import com.coletas.coletas.util.CreateKey;

import jakarta.transaction.Transactional;

@Service
public class CollectServiceImpl extends BaseServiceImpl<Collect, Integer> implements CollectService {
	
	@Autowired
	private CollectDAO dao;
	
	@Autowired
	private CreateKey key;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private CollectItensDAO collectItensDAO;
	
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


	@Override
	public Boolean editCollect(List<CollectEditRequestDTO> collect) {
		
		Users laster = userDAO.getById(collect.get(0).getLastModificationBy());
		
		try {
			for (CollectEditRequestDTO collectEditRequestDTO : collect) {
				Collect savedCollect = dao.get(collectEditRequestDTO.getIdCollect()).orElseThrow();
				
				savedCollect.setLastModificationDate(LocalDateTime.now());
				savedCollect.setLastModificationBy(laster);
				
				for (CollectItensDTO item : collectEditRequestDTO.getItens()) {
					CollectItens c = collectItensDAO.get(item.getIdCollectItens()).orElseThrow();
					c.setLastModificationBy(laster);
					c.setlastmodificationdate(LocalDateTime.now());
					c.setQuantity(item.getQuantity());
					c.setValuePerUnitCollect(item.getValuePerUnitCollect());
					c.setTotalToReceave(item.getTotalToReceive());
					c.setDeliveryStatus(item.getDeliveryStatus());
					
					collectItensDAO.saveObject(c);
					
				}
				
				dao.save(savedCollect);
			}
			return true;
				
		} catch (Exception e) {
			throw new RuntimeException("Erro ao editar usuário!");
		}
		
	}
	

}
