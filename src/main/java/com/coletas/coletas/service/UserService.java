package com.coletas.coletas.service;

import java.util.List;

import com.coletas.coletas.dto.UserDTO;
import com.coletas.coletas.dto.UserRequesDTO;
import com.coletas.coletas.dto.UserWithHierarchyDTO;
import com.coletas.coletas.model.Users;

public interface UserService extends BaseService<Users, Integer> {
	
	Boolean searchUser(String userKey);
	Boolean saveUser(Users user);
	Users getUserByKey(String userKey);
	UserDTO getUserDTOByKey(String userKey);
	List<UserDTO> getUserDTOByRole(Integer role);
	Boolean saveUserDTO(UserRequesDTO user);
	List<UserDTO> getDTOByFilters(UserRequesDTO user);
	Users getById(Integer id);
	UserWithHierarchyDTO getUserWithHierarchy(Integer id);
	

}
