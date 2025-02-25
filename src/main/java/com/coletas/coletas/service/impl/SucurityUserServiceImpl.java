package com.coletas.coletas.service.impl;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

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
	
	
	public String decryptPassword(String userKey) {
	    try {
	        SecurityUser securityUser = dao.getByUserKey(userKey);
	        if (securityUser == null) {
	            throw new RuntimeException("Usuário não encontrado: " + userKey);
	        }

	        String encryptedPassword = securityUser.getPassword().trim();
	        System.out.println("Encrypted password (Base64): " + encryptedPassword);

	        byte[] decodedBytes = Base64.getDecoder().decode(encryptedPassword);
	        System.out.println("Decoded byte array length: " + decodedBytes.length);

	        SecretKey secretKey = KeyManager.loadKey();
	        System.out.println("Secret Key Length: " + secretKey.getEncoded().length * 8 + " bits");

	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

	        byte[] iv = new byte[16]; 
	        IvParameterSpec ivSpec = new IvParameterSpec(iv);

	        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);

	        byte[] decryptedBytes = cipher.doFinal(decodedBytes);

	        return new String(decryptedBytes, StandardCharsets.UTF_8);
	    } catch (Exception e) {
	        throw new RuntimeException("Erro ao descriptografar a senha: " + e.getMessage(), e);
	    }
	}

	@Override
	@Transactional
	public Boolean login(Users user) {
		return user.getPassword().equals(decryptPassword(user.getUserKey())) ? true : false;
	}
	
	
	
	@Override
	public void save(SecurityUser entity) {
		
	}




}
