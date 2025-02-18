package com.coletas.coletas.dao;

import java.time.LocalDate;
import java.util.List;

import com.coletas.coletas.model.Collect;

public interface CollectDAO extends BaseDAO<Collect, Integer>{
	
	List<Collect> getByUserKeyAndDate(String userKey, LocalDate date);
	List<Collect> getByUserKeyAndDate(String userKey);
	Integer countCollectByUserAndDate(Integer userId, LocalDate date);
	

}
