package com.coletas.coletas.dao;

import java.util.List;

import com.coletas.coletas.dto.CollectPreValueDTO;
import com.coletas.coletas.model.CollectPreValue;

public interface CollectPreValueDAO extends BaseDAO<CollectPreValue, Integer> {
	
	public List<CollectPreValueDTO> getByAddresses(List<Integer> idAddresses);


}
