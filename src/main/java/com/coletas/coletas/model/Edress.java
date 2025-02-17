package com.coletas.coletas.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Edress implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEdress;
	
	private	String description;
	private String edress;
	private Boolean status;
	
	public Edress() {
	}

	public Edress(String description, String edress, Boolean status) {
		super();
		this.description = description;
		this.edress = edress;
		this.status = status;
	}

	public Integer getIdEdress() {
		return idEdress;
	}

	public void setIdEdress(Integer idEdress) {
		this.idEdress = idEdress;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEdress() {
		return edress;
	}

	public void setEdress(String edress) {
		this.edress = edress;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idEdress);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edress other = (Edress) obj;
		return Objects.equals(idEdress, other.idEdress);
	}

	@Override
	public String toString() {
		return "Edress [idEdress=" + idEdress + ", description=" + description + ", edress=" + edress + ", status="
				+ status + "]";
	}
	
	
}
