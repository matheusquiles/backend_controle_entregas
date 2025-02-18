package com.coletas.coletas.service;

import java.util.List;

import com.coletas.coletas.model.CollectItens;

public interface ColletItensService extends BaseService<CollectItens, Integer> {
	
	List<CollectItens> serchByCollectId(Integer idCollect);

}
