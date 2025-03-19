package com.coletas.coletas.dao;

import com.coletas.coletas.model.Edress;

public interface EdressDAO extends BaseDAO<Edress, Integer> {
	
	Double getPreValue(Integer idEdress, Integer idCollectType);

}
