package com.coletas.coletas.service;

import java.util.List;

import com.coletas.coletas.dto.UserDTO;
import com.coletas.coletas.model.Users;

public interface UserService extends BaseService<Users, Integer> {
	
	Boolean searchUser(String userKey);
	Boolean saveUser(Users user);
	Users getUserByKey(String userKey);
	UserDTO getUserDTOByKey(String userKey);
	List<UserDTO> getUserDTOByRole(Integer role);

}
