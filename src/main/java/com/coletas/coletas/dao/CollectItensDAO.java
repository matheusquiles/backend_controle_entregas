package com.coletas.coletas.dao;

import java.util.List;

import com.coletas.coletas.dto.CollectItensDTO;
import com.coletas.coletas.model.CollectItens;

public interface CollectItensDAO extends BaseDAO<CollectItens, Integer> {
	
	List<CollectItens> serchByCollectId(Integer idCollect);
	List<CollectItens> searchByCollectKey(String collectKey);
	List<CollectItensDTO> searchDTOByIdCollect (Integer idCollect, String deliveryStatus);

}
