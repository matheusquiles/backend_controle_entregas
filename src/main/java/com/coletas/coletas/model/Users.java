package com.coletas.coletas.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.data.annotation.Transient;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Users implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUser;

	private String name;
	private String cpf;
	private String email;
	private String userKey;
	private Boolean status;
	@Column(updatable = false)
	private LocalDateTime creationDate;
	private LocalDateTime lastModificationDate;
	
	
	@Transient
	private String password;
	
	@Transient
	private Integer hierarchy;
	
	@OneToOne()
	@JoinColumn(name = "user_type")
	private UserType userType;
	
	@OneToOne()
	@JoinColumn(name = "permission")
	private Permission permission;
	
	public Users() {
	}

	public Users(String name, String cpf, String email, String userKey, Boolean status, String password,
			UserType userType, Permission permission) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.userKey = userKey;
		this.status = status;
		this.password = password;
		this.userType = userType;
		this.permission = permission;
	}
	
	public Users(String name, String cpf, String email, String userKey, Boolean status, LocalDateTime creationDate,
			LocalDateTime lastModificationDate, String password, UserType userType,
			Permission permission, Integer hierarchy) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.userKey = userKey;
		this.status = status;
		this.creationDate = creationDate;
		this.lastModificationDate = lastModificationDate;
		this.password = password;
		this.userType = userType;
		this.permission = permission;
		this.hierarchy = hierarchy;
	}

	public Users(String userKey, String password) {
		super();
		this.userKey = userKey;
		this.password = password;
	}
	
	public Users(Integer idUser, String password) {
		super();
		this.idUser = idUser;
		this.password = password;
	}

	public Users(Integer idUser) {
		super();
		this.idUser = idUser;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public Integer getHierarchy() {
		return hierarchy;
	}

	public void setHierarchy(Integer hierarchy) {
		this.hierarchy = hierarchy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserKey() {
		return userKey;
	}

	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDateTime getLastModificationDate() {
		return lastModificationDate;
	}

	public void setLastModificationDate(LocalDateTime lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idUser);
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return Objects.equals(idUser, other.idUser);
	}

	@Override
	public String toString() {
		return "Users [idUser=" + idUser + ", name=" + name + ", cpf=" + cpf + ", email=" + email + ", userKey="
				+ userKey + ", status=" + status + ", creationDate=" + creationDate + ", lastModificationDate="
				+ lastModificationDate + ", permission=" + permission + "]";
	}
	
	
	
}
