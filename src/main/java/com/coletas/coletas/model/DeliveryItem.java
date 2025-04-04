package com.coletas.coletas.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class DeliveryItem implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDeliveryItens;
	
	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name = "delivery", nullable=false)
	private Delivery delivery;
	
	@OneToOne()
	@JoinColumn(name = "delivery_type")
	private DeliveryType deliveryType;
	
	private Integer quantity;
	
	private String deliveryStatus;
	@Column(updatable = false)
	private LocalDateTime creationDate;
	private LocalDateTime lastModificationDate;
	
	private Double valuePerUnitDelivery;
	private Double totalToReceive;
	
	
	@OneToOne()
	@JoinColumn(name = "created_by")
	private Users createdBy;
	
	@OneToOne()
	@JoinColumn(name = "last_modification_by")
	private Users lastModificationBy;
	
	public DeliveryItem() {
	}

	public DeliveryItem(Delivery delivery, DeliveryType deliveryType, Integer quantity, String deliveryStatus,
			Double valuePerUnitDelivery, Users createdBy) {
		super();
		this.delivery = delivery;
		this.deliveryType = deliveryType;
		this.quantity = quantity;
		this.deliveryStatus = deliveryStatus;
		this.valuePerUnitDelivery = valuePerUnitDelivery;
		this.createdBy = createdBy;
	}

	public Integer getIdDeliveryItens() {
		return idDeliveryItens;
	}

	public void setIdDeliveryItens(Integer idDeliveryItens) {
		this.idDeliveryItens = idDeliveryItens;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public DeliveryType getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(DeliveryType deliveryType) {
		this.deliveryType = deliveryType;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
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

	public Double getValuePerUnitDelivery() {
		return valuePerUnitDelivery;
	}

	public void setValuePerUnitDelivery(Double valuePerUnitDelivery) {
		this.valuePerUnitDelivery = valuePerUnitDelivery;
	}

	public Double getTotalToReceive() {
		return totalToReceive;
	}

	public void setTotalToReceive(Double totalToReceive) {
		this.totalToReceive = totalToReceive;
	}

	public Users getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Users createdBy) {
		this.createdBy = createdBy;
	}

	public Users getLastModificationBy() {
		return lastModificationBy;
	}

	public void setLastModificationBy(Users lastModificationBy) {
		this.lastModificationBy = lastModificationBy;
	}

	@Override
	public String toString() {
		return "DeliveryItem [idDeliveryItens=" + idDeliveryItens + "]";
	}

	public DeliveryItem(Integer idDeliveryItens, Delivery delivery, DeliveryType deliveryType, Integer quantity,
			String deliveryStatus, LocalDateTime creationDate, LocalDateTime lastModificationDate,
			Double valuePerUnitDelivery, Double totalToReceive, Users createdBy, Users lastModificationBy) {
		super();
		this.idDeliveryItens = idDeliveryItens;
		this.delivery = delivery;
		this.deliveryType = deliveryType;
		this.quantity = quantity;
		this.deliveryStatus = deliveryStatus;
		this.creationDate = creationDate;
		this.lastModificationDate = lastModificationDate;
		this.valuePerUnitDelivery = valuePerUnitDelivery;
		this.totalToReceive = totalToReceive;
		this.createdBy = createdBy;
		this.lastModificationBy = lastModificationBy;
	}
	
}
