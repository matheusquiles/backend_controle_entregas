package com.coletas.coletas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.coletas.coletas.dao.BaseDAO;
import com.coletas.coletas.service.BaseService;

import jakarta.transaction.Transactional;

public abstract class BaseServiceImpl <T, ID> implements BaseService<T, ID> {
	
	@Autowired
    protected BaseDAO<T, ID> dao;

    @Override
    @Transactional
    public List<T> findAll() {
        return dao.getAll();
    }

    @Override
    @Transactional
    public Optional<T> findById(ID id) {
        return dao.get(id);
    }

    @Override
    @Transactional
    public void deleteById(ID id) {
        dao.delete(id);
    }
    
    @Override
    @Transactional
	public void update(T entity) {
    	dao.save(entity);
    }
    
    @Override
    @Transactional
    public Boolean findByDescription(String s) {
    	Optional<T> entity = dao.getByDescription(s);
		if(entity.isEmpty()) {
			return false;
		}
		return true;
    }

}
