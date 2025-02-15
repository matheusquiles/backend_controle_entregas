package com.coletas.coletas.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<T, ID> {
	
	List<T> findAll();

	Optional<T> findById(ID id);

	void deleteById(ID id);

	void update(T entity);
	
	void save(T entity);
	
	Boolean findByDescription(String s);

}
