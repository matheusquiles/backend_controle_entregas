package com.coletas.coletas.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.coletas.coletas.dao.SecurityUserDAO;
import com.coletas.coletas.dao.UserDAO;
import com.coletas.coletas.model.SecurityUser;
import com.coletas.coletas.model.Users;
import com.coletas.coletas.service.SecurityUserService;

import jakarta.transaction.Transactional;

@Service
public class SecurityUserServiceImpl extends BaseServiceImpl<SecurityUser, Integer> implements SecurityUserService, UserDetailsService {

	@Autowired
	private SecurityUserDAO dao;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	@Lazy
	private BCryptPasswordEncoder passwordEncoder;
	
	
	@Transactional
	@Override
	public void save(Users entity) {
	    Users u = userDAO.getUserByKey(entity.getUserKey());

	    try {
	        SecurityUser securityUser = new SecurityUser();
	        securityUser.setUsers(u);
	        securityUser.setPassword(passwordEncoder.encode(entity.getPassword())); 

	        dao.save(securityUser);
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException("Erro ao salvar usuário: " + e.getMessage(), e);
	    }
	}
	
	

	@Override
	@Transactional
	public Boolean login(Users user) {
	    SecurityUser userFromDb = dao.getByUserKey(user.getUserKey());
	    if (userFromDb == null) {
	    	System.out.println(("❌ Usuário não encontrado: " + user.getUserKey()));
	        return false;
	    }

	    System.out.println("🔒 Comparando senhas para usuário: " + user.getUserKey());
	    System.out.println("Senha informada: " + user.getPassword());
	    System.out.println("Senha do banco: " + userFromDb.getPassword());

	    boolean passwordMatches = passwordEncoder.matches(user.getPassword(), userFromDb.getPassword());

	    if (passwordMatches) {
	    	System.out.println("✅ Senha correta para usuário: " + user.getUserKey());
	    } else {
	    	System.out.println("❌ Senha incorreta para usuário: " + user.getUserKey());
	    }

	    return passwordMatches;
	}
	
	
	
	@Override
	public void save(SecurityUser entity) {
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		SecurityUser securityUser = dao.getByUserKey(username);
		
		if (securityUser == null) {
            System.out.println("❌ Usuário não encontrado: " + username);
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
		
		System.out.println("✅ Usuário encontrado: " + username);
		
		Users u = new Users(securityUser.getUsers().getUserKey(), securityUser.getPassword());
		
		return new org.springframework.security.core.userdetails.User(
				u.getUserKey(),
				u.getPassword(),
	            new ArrayList<>()
	        );
	}




}
