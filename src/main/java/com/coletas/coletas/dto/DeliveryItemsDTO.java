package com.coletas.coletas.dto;

public class DeliveryItemsDTO {
	
	private Integer idDeliveryItems;
	private Integer idDelivery;
	private String deliveryKey;
	private Integer idDeliveryType;
	private String deliveryType;
	private Integer quantity;
	private String deliveryStatus;
	private Double valuePerUnitDelivery;
	private Double totalToPay;
	
	public DeliveryItemsDTO() {
	}

	public DeliveryItemsDTO(Integer idDeliveryItems, Integer idDelivery, String deliveryKey, Integer idDeliveryType,
			String deliveryType, Integer quantity, String deliveryStatus, Double valuePerUnitDelivery,
			Double totalToPay) {
		super();
		this.idDeliveryItems = idDeliveryItems;
		this.idDelivery = idDelivery;
		this.deliveryKey = deliveryKey;
		this.idDeliveryType = idDeliveryType;
		this.deliveryType = deliveryType;
		this.quantity = quantity;
		this.deliveryStatus = deliveryStatus;
		this.valuePerUnitDelivery = valuePerUnitDelivery;
		this.totalToPay = totalToPay;
	}

	public Integer getIdDeliveryItems() {
		return idDeliveryItems;
	}

	public void setIdDeliveryItems(Integer idDeliveryItems) {
		this.idDeliveryItems = idDeliveryItems;
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

	public Integer getIdDeliveryType() {
		return idDeliveryType;
	}

	public void setIdDeliveryType(Integer idDeliveryType) {
		this.idDeliveryType = idDeliveryType;
	}

	public String getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
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

	public Double getValuePerUnitDelivery() {
		return valuePerUnitDelivery;
	}

	public void setValuePerUnitDelivery(Double valuePerUnitDelivery) {
		this.valuePerUnitDelivery = valuePerUnitDelivery;
	}

	public Double getTotalToPay() {
		return totalToPay;
	}

	public void setTotalToPay(Double totalToPay) {
		this.totalToPay = totalToPay;
	}

}
