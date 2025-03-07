package com.coletas.coletas.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coletas.coletas.dao.BaseDAO;
import com.coletas.coletas.dao.CollectDAO;
import com.coletas.coletas.dao.CollectItensDAO;
import com.coletas.coletas.model.Collect;
import com.coletas.coletas.model.CollectItens;
import com.coletas.coletas.service.CollectItensService;
import com.coletas.coletas.util.DeliveryStatus;

import jakarta.transaction.Transactional;

@Service
public class CollectItensServiceImpl extends BaseServiceImpl<CollectItens, Integer> implements CollectItensService {

	@Autowired
	private CollectItensDAO dao;
	
	@Autowired
	private CollectDAO collectDAO;

	@Override
	@Transactional
	public void save(CollectItens entity) {
		dao.save(entity);
	}

	@Override
	public List<CollectItens> serchByCollectId(Integer idCollect) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Boolean saveCollectItens(Collect collect) {
		
		Collect c = collectDAO.getByCollectKey(collect.getCollectKey());

		if (!collect.getItens().isEmpty()) {
			for (CollectItens collectItens : collect.getItens()) {
				collectItens.setCollect(c);
				collectItens.setCreationDate(LocalDateTime.now());
				collectItens.setCreatedBy(collect.getUserId()); 
				collectItens.setValuePerUnitCollect(new Double(20));
				collectItens.setTotalToReceave(collectItens.getValuePerUnitCollect()*collectItens.getQuantity());
				collectItens.setDeliveryStatus(DeliveryStatus.PENDENTE.getDescricao());

				try {
					dao.save(collectItens);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return true;
		}
		return false;
	}

	private <T> T getEntity(BaseDAO<T, Integer> dao, Integer id, String errorMessage) {
		return dao.get(id).orElseThrow(() -> new RuntimeException(errorMessage));
	}
}
