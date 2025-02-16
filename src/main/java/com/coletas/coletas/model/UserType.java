package com.coletas.coletas.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_type")
public class UserType implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUserType;
	private String description;
	
	public UserType() {
	}
	
	public UserType(Integer idUserType) {
		super();
		this.idUserType = idUserType;
	}

	public UserType(Integer idUserType, String description) {
		super();
		this.idUserType = idUserType;
		this.description = description;
	}

	public Integer getIdUserType() {
		return idUserType;
	}

	public void setIdUserType(Integer idUserType) {
		this.idUserType = idUserType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idUserType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserType other = (UserType) obj;
		return Objects.equals(idUserType, other.idUserType);
	}

	@Override
	public String toString() {
		return "UserType [idUserType=" + idUserType + ", description=" + description + "]";
	}
	
	
	

}
