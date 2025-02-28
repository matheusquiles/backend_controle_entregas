package com.coletas.coletas.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coletas.coletas.dao.UserDAO;
import com.coletas.coletas.dto.UserDTO;
import com.coletas.coletas.model.Permission;
import com.coletas.coletas.model.Users;
import com.coletas.coletas.service.SecurityUserService;
import com.coletas.coletas.service.UserService;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl extends BaseServiceImpl<Users, Integer> implements UserService {

	@Autowired
	private UserDAO dao;
	@Autowired
	private SecurityUserService securityService;

	@Transactional
	@Override
	public void save(Users entity) {
		try {
			entity.setCreationDate(LocalDateTime.now());
			dao.save(entity);

		} catch (Exception e) {
			throw new RuntimeException("Failed to save user: " + entity.getUserKey(), e);
		}
	}

	@Transactional
	private void savePassword(Users entity) {
		try {
			securityService.save(entity);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Boolean searchUser(String userKey) {
		return dao.getByUserKey(userKey);
	}

	@Override
	public Boolean saveUser(Users user) {
		try {
			
			Users u = new Users();
			u.setCpf(user.getCpf());
			u.setEmail(user.getEmail());
			u.setName(user.getName());
			u.setUserKey(user.getUserKey());
			u.setUserType(user.getUserType());
			u.setCreationDate(LocalDateTime.now());
			//adicionando essa permissão manualmente para testes do frontend. Eventualmente cada usuário poderá ter permissões distinta
			u.setPermission(new Permission(user.getUserType().getIdUserType()));
			//também adicionando para testes
			u.setStatus(true);
			u.setPassword("");
			dao.save(u);
			return true;

		} catch (Exception e) {
			throw new RuntimeException("Failed to save user: " + user.getUserKey(), e);
		}
	}

	@Override
	public Users getUserByKey(String userKey) {
		return dao.getUserByKey(userKey);
	}

	@Override
	public UserDTO getUserDTOByKey(String userKey) {
		return dao.getUserDTOByKey(userKey);
	}

	@Override
	public List<UserDTO> getUserDTOByRole() {
		return dao.getUserDTOByRole();
	}


}
