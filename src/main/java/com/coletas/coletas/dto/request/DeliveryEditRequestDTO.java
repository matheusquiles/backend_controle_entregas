package com.coletas.coletas.dto.request;

public class DeliveryEditRequestDTO {
	
	private Integer idDelivery;
	private Double value;
	private Integer idDeliveryRegion;
	private String deliveryStatus;
	private Integer lastModificationBy;
	
	public DeliveryEditRequestDTO() {
	}

	public DeliveryEditRequestDTO(Integer idDelivery, Double value, Integer idDeliveryRegion, String deliveryStatus, Integer lastModificationBy) {
		super();
		this.idDelivery = idDelivery;
		this.value = value;
		this.deliveryStatus = deliveryStatus;
		this.lastModificationBy = lastModificationBy;
		this.idDeliveryRegion = idDeliveryRegion;
	}

	public Integer getIdDelivery() {
		return idDelivery;
	}

	public void setIdDelivery(Integer idDelivery) {
		this.idDelivery = idDelivery;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public Integer getLastModificationBy() {
		return lastModificationBy;
	}

	public void setLastModificationBy(Integer lastModificationBy) {
		this.lastModificationBy = lastModificationBy;
	}

	public Integer getIdDeliveryRegion() {
		return idDeliveryRegion;
	}

	public void setIdDeliveryRegion(Integer idDeliveryRegion) {
		this.idDeliveryRegion = idDeliveryRegion;
	}


}
