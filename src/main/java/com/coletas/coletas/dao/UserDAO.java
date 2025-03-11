package com.coletas.coletas.dao;

import java.util.List;
import java.util.Optional;

import com.coletas.coletas.dto.UserDTO;
import com.coletas.coletas.dto.UserRequesDTO;
import com.coletas.coletas.model.Users;

	
public interface UserDAO extends BaseDAO<Users, Integer> {
	Optional<Users> getByDescription(String escritorio); 
	Boolean getByUserKey(String userKey);
	Users getById(Integer id);
	Users getUserByKey(String userkey);
	UserDTO getUserDTOByKey(String userKey);
	List<UserDTO> getUserDTOByRole(Integer role);
	List<UserDTO> getDTOByFilters(UserRequesDTO user);
}
