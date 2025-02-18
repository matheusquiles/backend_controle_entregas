package com.coletas.coletas.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coletas.coletas.model.CollectItens;
import com.coletas.coletas.service.ColletItensService;

@Service
public class CollectItensServiceImpl extends BaseServiceImpl<CollectItens, Integer> implements ColletItensService {

	@Override
	public void save(CollectItens entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CollectItens> serchByCollectId(Integer idCollect) {
		// TODO Auto-generated method stub
		return null;
	}


}
