package com.coletas.coletas.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CollectType implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCollectType;
	private String description;
	private Boolean status;
	
	public CollectType() {
	}
	
	public CollectType(String description, Boolean status) {
		super();
		this.description = description;
		this.status = status;
	}

	public Integer getIdCollectType() {
		return idCollectType;
	}

	public void setIdCollectType(Integer idCollectType) {
		this.idCollectType = idCollectType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCollectType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CollectType other = (CollectType) obj;
		return Objects.equals(idCollectType, other.idCollectType);
	}

	@Override
	public String toString() {
		return "CollectType [idCollectType=" + idCollectType + ", description=" + description + ", status=" + status
				+ "]";
	}

}
