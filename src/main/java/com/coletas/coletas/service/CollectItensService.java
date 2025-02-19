package com.coletas.coletas.service;

import java.util.List;

import com.coletas.coletas.model.Collect;
import com.coletas.coletas.model.CollectItens;

public interface CollectItensService extends BaseService<CollectItens, Integer> {
	
	List<CollectItens> serchByCollectId(Integer idCollect);
	Boolean saveCollectItens(Collect collect);

}
