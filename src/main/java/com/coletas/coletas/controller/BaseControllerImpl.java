package com.coletas.coletas.controller;

import java.util.List;
import java.util.Optional;

import com.coletas.coletas.service.BaseService;
import com.coletas.coletas.util.DescriptionRequest;


public abstract class BaseControllerImpl<T, ID> implements BaseController<T, ID> {
	
	private final BaseService<T, ID> service;

    public BaseControllerImpl(BaseService<T, ID> service) {
        this.service = service;
    }

    @Override
    public List<T> getAll() {
        return service.findAll();
    }

    @Override
    public T get(ID id) {
        Optional<T> entity = service.findById(id);
        return entity.orElse(null); 
    }

    @Override
    public Boolean save(T entity) {
    	service.save(entity);
    	return true;
    }

    @Override
    public boolean buscarPorDescricao(DescriptionRequest request) {
        return service.findByDescription(request.getDescription());
    }

    @Override
    public String delete(ID id) {
        service.deleteById(id);
        return "Deleted";
    }

    @Override
    public T update(T entity) {
      service.update(entity);
	return entity;
    }

}
