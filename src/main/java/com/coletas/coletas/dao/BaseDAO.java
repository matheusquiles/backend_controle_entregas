package com.coletas.coletas.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public interface BaseDAO <T, ID>{

	List<T> getAll();
    Optional<T> get(ID id);
    void save(T entity);
    void delete(ID id);
    Optional<T> getByDescription(String description);
}
