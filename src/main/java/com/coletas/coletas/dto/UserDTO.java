package com.coletas.coletas.dto;

public class UserDTO {
	
	private Integer idUser;
	private String name;
	private String cpf;
	private String email;
	private String userKey;
	private Boolean status;
	private String userType;
	
	public UserDTO() {
	}

	public UserDTO(Integer idUser, String name, String cpf, String email, String userKey, Boolean status,
			String userType) {
		super();
		this.idUser = idUser;
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.userKey = userKey;
		this.status = status;
		this.userType = userType;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
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

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	
	

}
