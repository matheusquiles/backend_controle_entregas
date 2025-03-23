package com.coletas.coletas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coletas.coletas.dto.AddressDTO;
import com.coletas.coletas.dto.request.AddressRequest;
import com.coletas.coletas.model.Edress;
import com.coletas.coletas.service.impl.EdressServiceImpl;

@RestController
@RequestMapping("/api/edress")
public class EdressController extends BaseControllerImpl<Edress, Integer> {
	
	@Autowired
	private EdressServiceImpl service;
	
	public EdressController(EdressServiceImpl service) {
		super(service);
	}
	
	@PostMapping("/editAddress")
	public Boolean editUser(@RequestBody List<AddressDTO> addresses) {
		try {
			service.editAddress(addresses);
			return true;
		} catch (Exception e) {
			throw new RuntimeException("Erro ao editar usuário!");
		}
	}
	
	
	@PostMapping("/getDTO")
	public List<AddressDTO> getByFilters(@RequestBody AddressRequest address){
		try {
			
			List<AddressDTO> result = service.getByFilters(address);
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	


}
