package com.coletas.coletas.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coletas.coletas.dao.HierarchyDAO;
import com.coletas.coletas.dao.UserDAO;
import com.coletas.coletas.dao.UserTypeDAO;
import com.coletas.coletas.dto.UserDTO;
import com.coletas.coletas.dto.UserRequestDTO;
import com.coletas.coletas.model.Hierarchy;
import com.coletas.coletas.model.Permission;
import com.coletas.coletas.model.UserType;
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
	@Autowired
	private HierarchyDAO hierarchyDAO;
	@Autowired
	private UserTypeDAO userTypeDAO;

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


	@Override
	public Boolean searchUser(String userKey) {
		return dao.getByUserKey(userKey);
	}

	@Transactional
	@Override
	public Boolean saveUser(Users user) {
		return false;
	}
	
	@Transactional
	public Boolean saveUserDTO (UserRequestDTO user) {
		try {
			
			Users u = new Users();
			u.setCpf(user.getCpf());
			u.setEmail(user.getEmail());
			u.setName(user.getName());
			u.setUserKey(user.getUserKey());
			
			UserType userType = userTypeDAO.get(user.getUserType()).orElse(null);
			u.setUserType(userType);
			
			u.setCreationDate(LocalDateTime.now());
			//adicionando essa permissão manualmente para testes do frontend. Eventualmente cada usuário poderá ter permissões distinta
			u.setPermission(new Permission(userType.getIdUserType()));
			u.setStatus(true);
			
			Users savedUser = dao.saveObject(u);
			securityService.save(savedUser, user.getPassword());
			
			if (user.getHierarchy() != null) {
				Users coordinator = dao.get(user.getHierarchy()).orElse(null);
				if (coordinator != null) {
					hierarchyDAO.save(new Hierarchy(savedUser, coordinator));
				} else {
					System.out.println("Coordenador com ID " + user.getHierarchy() + " não encontrado. Hierarquia não será salva.");
				}
			}
			
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
	public List<UserDTO> getUserDTOByRole(Integer role) {
		return dao.getUserDTOByRole(role);
	}


}
