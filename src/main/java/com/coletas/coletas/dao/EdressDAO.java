package com.coletas.coletas.dao;

import java.util.List;

import com.coletas.coletas.dto.AddressDTO;
import com.coletas.coletas.dto.request.AddressRequest;
import com.coletas.coletas.model.Edress;

public interface EdressDAO extends BaseDAO<Edress, Integer> {
	
	Double getPreValue(Integer idEdress, Integer idCollectType);
	List<AddressDTO> getByFilters(AddressRequest address);

}
