package com.coletas.coletas.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Permission implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPermission;
	private String description;
	
	public Permission() {
	}
	
	public Permission(Integer idPermission) {
		super();
		this.idPermission = idPermission;
	}

	public Permission(Integer idPermission, String description) {
		super();
		this.idPermission = idPermission;
		this.description = description;
	}

	public Integer getIdPermission() {
		return idPermission;
	}

	public void setIdPermission(Integer idPermission) {
		this.idPermission = idPermission;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
