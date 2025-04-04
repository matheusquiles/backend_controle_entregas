package com.coletas.coletas.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DeliveryType implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDeliveryType;
	private String description;
	private Boolean status;
	
	public DeliveryType() {
	}
	
	public DeliveryType(Integer idDeliveryType) {
		super();
		this.idDeliveryType = idDeliveryType;
	}
	
	public DeliveryType(String description, Boolean status) {
		super();
		this.description = description;
		this.status = status;
	}

	public DeliveryType(Integer idDeliveryType, String description, Boolean status) {
		super();
		this.idDeliveryType = idDeliveryType;
		this.description = description;
		this.status = status;
	}

	public Integer getIdDeliveryType() {
		return idDeliveryType;
	}

	public void setIdDeliveryType(Integer idDeliveryType) {
		this.idDeliveryType = idDeliveryType;
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
		return Objects.hash(idDeliveryType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeliveryType other = (DeliveryType) obj;
		return Objects.equals(idDeliveryType, other.idDeliveryType);
	}

	@Override
	public String toString() {
		return "DeliveryType [idDeliveryType=" + idDeliveryType + ", description=" + description + ", status=" + status
				+ "]";
	}
	

}
