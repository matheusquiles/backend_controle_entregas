package com.coletas.coletas.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.coletas.coletas.util.DescriptionRequest;


public interface BaseController<T, ID> {
	
	@GetMapping
    List<T> getAll();

    @GetMapping("/{id}")
    T get(@PathVariable ID id);

    @PostMapping("/save")
    Boolean save(@RequestBody T entity);

    @DeleteMapping("/del/{id}")
    String delete(@PathVariable ID id);

    @PutMapping("/modify")
    T update(@RequestBody T entity);
    
    @PostMapping("/searchDescription")
    boolean buscarPorDescricao(@RequestBody DescriptionRequest request);

}
