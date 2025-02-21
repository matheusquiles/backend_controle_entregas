package com.coletas.coletas.service;

import java.time.LocalDate;
import java.util.List;

import com.coletas.coletas.model.Collect;

public interface CollectService extends BaseService<Collect, Integer> {
	
	List<Collect> getByUserKeyAndDate(String userKey, LocalDate date);
	List<Collect> getByUserKeyAndDate(String userKey);
	Collect saveCollect(Collect entity);
	Integer countCollectByUserAndDate(Integer userId, LocalDate date);

}
