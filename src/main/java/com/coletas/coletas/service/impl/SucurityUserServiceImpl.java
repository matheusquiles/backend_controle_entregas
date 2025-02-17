package com.coletas.coletas.service.impl;

import java.nio.file.Files;
import java.nio.file.Paths;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coletas.coletas.config.KeyManager;
import com.coletas.coletas.dao.SecurityUserDAO;
import com.coletas.coletas.dao.UserDAO;
import com.coletas.coletas.model.SecurityUser;
import com.coletas.coletas.model.Users;
import com.coletas.coletas.service.SecurityUserService;

import jakarta.transaction.Transactional;

@Service
public class SucurityUserServiceImpl extends BaseServiceImpl<SecurityUser, Integer> implements SecurityUserService {

	@Autowired
	private SecurityUserDAO dao;
	
	@Autowired
	private UserDAO userDAO;
	
	@Transactional
	@Override
	public void save(Users entity) {
		
		Users u = userDAO.getUserByKey(entity.getUserKey());
		
		
		try {

			// Generate and save the key if it does not exist
			if (!Files.exists(Paths.get("encryption.key"))) {
				SecretKey secretKey = KeyManager.generateKey();
				KeyManager.saveKey(secretKey);
			}

			SecurityUser securityUser = new SecurityUser();
			securityUser.setUsers(u);
			securityUser.setPassword(entity.getPassword());

//			// Print encrypted password
			System.out.println("Encrypted Password: " + securityUser.getPassword());
//
//			// Decrypt and print the password
			System.out.println("Decrypted Password: " + securityUser.getPassword());
			
			dao.save(securityUser);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void save(SecurityUser entity) {
		// TODO Auto-generated method stub
		
	}


}
