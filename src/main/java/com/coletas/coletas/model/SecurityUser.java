package com.coletas.coletas.model;

import java.io.Serializable;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

import com.coletas.coletas.config.KeyManager;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class SecurityUser implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSecurityUser;
	@OneToOne()
	@JoinColumn(name = "users")
	private Users users;
	private String password;
	
//    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";

    public SecurityUser() {}

    public SecurityUser(Integer idSecurityUser, Users idUser, String password) {
        this.idSecurityUser = idSecurityUser;
        this.users = idUser;
        this.password = encrypt(password);
    }

    public Integer getIdSecurityUser() {
        return idSecurityUser;
    }
    

    public SecurityUser(Users idUser, String password) {
		super();
		this.users = idUser;
		this.password = password;
	}

	public void setIdSecurityUser(Integer idSecurityUser) {
        this.idSecurityUser = idSecurityUser;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users idUser) {
        this.users = idUser;
    }

    public String getPassword() {
        return decrypt(password);
    }

    public void setPassword(String password) {
        this.password = encrypt(password);
    }

    private String encrypt(String data) {
        try {
            SecretKey secretKey = KeyManager.loadKey();
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Error while encrypting: " + e.toString());
        }
    }

    private String decrypt(String encryptedData) {
        try {
            SecretKey secretKey = KeyManager.loadKey();
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
            byte[] decryptedBytes = cipher.doFinal(decodedBytes);
            return new String(decryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Error while decrypting: " + e.toString());
        }
    }

}
