package com.coletas.coletas.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DeliveryRegion implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDeliveryRegion;
	private	String deliveryRegion;
	private Boolean status;
	
	public DeliveryRegion() {
	}
	
	public DeliveryRegion(Integer idDeliveryRegion) {
		super();
		this.idDeliveryRegion = idDeliveryRegion;
	}

	public DeliveryRegion(Integer idDeliveryRegion, String deliveryRegion, Boolean status) {
		super();
		this.idDeliveryRegion = idDeliveryRegion;
		this.deliveryRegion = deliveryRegion;
		this.status = status;
	}
	
	public DeliveryRegion(String deliveryRegion, Boolean status) {
		super();
		this.deliveryRegion = deliveryRegion;
		this.status = status;
	}

	public Integer getIdDeliveryRegion() {
		return idDeliveryRegion;
	}

	public void setIdDeliveryRegion(Integer idDeliveryRegion) {
		this.idDeliveryRegion = idDeliveryRegion;
	}

	public String getDeliveryRegion() {
		return deliveryRegion;
	}

	public void setDeliveryRegion(String deliveryRegion) {
		this.deliveryRegion = deliveryRegion;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	

}
