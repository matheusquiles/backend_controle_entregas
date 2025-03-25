package com.coletas.coletas.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Delivery implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDelivery;
	
	private String deliveryKey;
	private Double value;
	
	@OneToOne()
	@JoinColumn(name = "motoboy")
	private Users motoboy;
	
	@OneToOne()
	@JoinColumn(name = "delivery_region")
	private DeliveryRegion deliveryRegion;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate date;
	private Boolean status;
	@Column(updatable = false)
	private LocalDateTime creationDate;
	private LocalDateTime lastModificationDate;
	
	@OneToOne()
	@JoinColumn(name = "created_by")
	private Users createdBy;
	
	@OneToOne()
	@JoinColumn(name = "last_modification_by")
	private Users lastModificationBy;
	
	private String deliveryStatus;
	
	public Delivery() {
	}

	public Delivery(Integer idDelivery, String deliveryKey, Double value, Users motoboy, DeliveryRegion deliveryRegion,
			LocalDate date, Boolean status, LocalDateTime creationDate, LocalDateTime lastModificationDate,
			Users createdBy, Users lastModificationBy) {
		super();
		this.idDelivery = idDelivery;
		this.deliveryKey = deliveryKey;
		this.value = value;
		this.motoboy = motoboy;
		this.deliveryRegion = deliveryRegion;
		this.date = date;
		this.status = status;
		this.creationDate = creationDate;
		this.lastModificationDate = lastModificationDate;
		this.createdBy = createdBy;
		this.lastModificationBy = lastModificationBy;
	}
	
	public Delivery(String deliveryKey, Double value, Users motoboy, DeliveryRegion deliveryRegion, LocalDate date,
			Boolean status, LocalDateTime creationDate, LocalDateTime lastModificationDate, Users createdBy,
			Users lastModificationBy, String deliveryStatus) {
		super();
		this.deliveryKey = deliveryKey;
		this.value = value;
		this.motoboy = motoboy;
		this.deliveryRegion = deliveryRegion;
		this.date = date;
		this.status = status;
		this.creationDate = creationDate;
		this.lastModificationDate = lastModificationDate;
		this.createdBy = createdBy;
		this.lastModificationBy = lastModificationBy;
		this.deliveryStatus = deliveryStatus;
	}

	public Integer getIdDelivery() {
		return idDelivery;
	}

	public void setIdDelivery(Integer idDelivery) {
		this.idDelivery = idDelivery;
	}

	public String getDeliveryKey() {
		return deliveryKey;
	}

	public void setDeliveryKey(String deliveryKey) {
		this.deliveryKey = deliveryKey;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Users getMotoboy() {
		return motoboy;
	}

	public void setMotoboy(Users motoboy) {
		this.motoboy = motoboy;
	}

	public DeliveryRegion getDeliveryRegion() {
		return deliveryRegion;
	}

	public void setDeliveryRegion(DeliveryRegion deliveryRegion) {
		this.deliveryRegion = deliveryRegion;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
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
	
	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	@Override
	public String toString() {
		return "Delivery [idDelivery=" + idDelivery + ", deliveryKey=" + deliveryKey + ", motoboy=" + motoboy
				+ ", deliveryAdress=" + deliveryRegion + ", date=" + date + ", status=" + status + ", creationDate="
				+ creationDate + ", lastModificationDate=" + lastModificationDate + ", createdBy=" + createdBy
				+ ", lastModificationBy=" + lastModificationBy + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idDelivery);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Delivery other = (Delivery) obj;
		return Objects.equals(idDelivery, other.idDelivery);
	}
	

}
