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
	 private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";

    public SecurityUser() {}

    public SecurityUser(Integer idSecurityUser, Users idUser, String password) {
        this.idSecurityUser = idSecurityUser;
        this.users = idUser;
        this.password = password;
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
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
