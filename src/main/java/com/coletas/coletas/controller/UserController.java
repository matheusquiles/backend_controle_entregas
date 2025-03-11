package com.coletas.coletas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coletas.coletas.dto.UserDTO;
import com.coletas.coletas.dto.UserRequesDTO;
import com.coletas.coletas.dto.UserWithHierarchyDTO;
import com.coletas.coletas.model.Users;
import com.coletas.coletas.service.UserService;
import com.coletas.coletas.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/api/users")
public class UserController extends BaseControllerImpl<Users, Integer> {

	@Autowired
	private UserService service;

	public UserController(UserServiceImpl service) {
		super(service);
	}

	@Override
	public Boolean save(Users user) {

		if (service.searchUser(user.getUserKey())) {
			System.err.println("User already exists: " + user.getUserKey());
			return false;
		}
		try {
			if (service.saveUser(user)) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			throw new RuntimeException("Failed to save user: " + user.getUserKey(), e);
		}

	}
	
	@PostMapping("/saveUser")
	public Boolean saveUser(@RequestBody UserRequesDTO user) {
		
		if (service.searchUser(user.getUserKey())) {
			System.err.println("User already exists: " + user.getUserKey());
			return false;
		}
		try {
			if (service.saveUserDTO(user)) {
				return true;
			} else {
				return false;
			}
			
		} catch (Exception e) {
			throw new RuntimeException("Failed to save user: " + user.getUserKey(), e);
		}
	}

	

	@GetMapping("/searchUser/{userKey}")
	public UserDTO getUserDTOByKey(@PathVariable String userKey) {
		return service.getUserDTOByKey(userKey);
	}
	
	@GetMapping("/getById/{id}")
	public UserWithHierarchyDTO getUserDTOByKey(@PathVariable Integer id) {
		return service.getUserWithHierarchy(id);
	}
	
	@GetMapping("/searchMotoboy")
	public List<UserDTO> getMotoboy() {
		//passando 3 apenas para testes. isso será alterado
		return service.getUserDTOByRole(3);
	}
	
	@GetMapping("/searchCordinator")
	public List<UserDTO> getCordinator() {
		//passando 2 apenas para testes. isso será alterado
		return service.getUserDTOByRole(2);
	}
	
	@PostMapping("/getDTO")
	public List<UserDTO> getDTOByFilters(@RequestBody UserRequesDTO user){
		try {
			
			List<UserDTO> result = service.getDTOByFilters(user);
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
