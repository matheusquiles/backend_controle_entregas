package com.coletas.coletas.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.coletas.coletas.dao.SecurityUserDAO;
import com.coletas.coletas.model.SecurityUser;
import com.coletas.coletas.model.Users;
import com.coletas.coletas.service.SecurityUserService;

import jakarta.transaction.Transactional;

@Service
public class SecurityUserServiceImpl extends BaseServiceImpl<SecurityUser, Integer> implements SecurityUserService, UserDetailsService {

	@Autowired
	private SecurityUserDAO dao;
	
	@Autowired
	@Lazy
	private BCryptPasswordEncoder passwordEncoder;
	
	
	@Transactional
	@Override
	public Boolean save(Users entity, String password) {
		try {
            SecurityUser securityUser = new SecurityUser();
            securityUser.setUsers(entity);
            securityUser.setPassword(passwordEncoder.encode(password));
            dao.saveObject(securityUser);
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar SecurityUser para o usuário: " + entity.getUserKey(), e);
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
	    boolean passwordMatches = passwordEncoder.matches(user.getPassword(), userFromDb.getPassword());
	    return passwordMatches;
	}
	
	
	
	@Override
	public void save(SecurityUser entity) {
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		SecurityUser securityUser = dao.getByUserKey(username);
		
		if (securityUser == null) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
		
		Users u = new Users(securityUser.getUsers().getUserKey(), securityUser.getPassword());
		List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(securityUser.getUsers().getPermission().getDescription()));
		
		return new org.springframework.security.core.userdetails.User(
				u.getUserKey(),
				u.getPassword(),
				authorities
	        );
	}



	@Override
	public Boolean changePassord(Users user) {
		try {
            SecurityUser securityUser = dao.getByUserId(user.getIdUser());
            
            if(securityUser != null) {
            	securityUser.setPassword(passwordEncoder.encode(user.getPassword()));
            	dao.saveObject(securityUser);
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar SecurityUser para o usuário: " + user.getUserKey(), e);
        }
	}


}
