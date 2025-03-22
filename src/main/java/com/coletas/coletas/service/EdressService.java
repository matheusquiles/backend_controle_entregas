package com.coletas.coletas.service;

import java.util.List;

import com.coletas.coletas.dto.AddressDTO;
import com.coletas.coletas.dto.request.AddressRequest;
import com.coletas.coletas.model.Edress;

public interface EdressService extends BaseService<Edress, Integer> {
	
	List<AddressDTO> getByFilters(AddressRequest address);

}
