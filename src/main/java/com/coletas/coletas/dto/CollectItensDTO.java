package com.coletas.coletas.dto;

public class CollectItensDTO {
	
	private String collectType;
	private Integer quantity;
	private Boolean deliveryStatus;
	private Double valuePerUnitCollect;
	private Double totalToReceive;
	private Double valueToPayPerUnit;
	private Double totalValueToPay;
	
	public CollectItensDTO() {
	}
	
	public CollectItensDTO(String collectType, Integer quantity, Boolean deliveryStatus, Double valuePerUnitCollect,
			Double totalToReceive, Double valueToPayPerUnit, Double totalValueToPay) {
		super();
		this.collectType = collectType;
		this.quantity = quantity;
		this.deliveryStatus = deliveryStatus;
		this.valuePerUnitCollect = valuePerUnitCollect;
		this.totalToReceive = totalToReceive;
		this.valueToPayPerUnit = valueToPayPerUnit;
		this.totalValueToPay = totalValueToPay;
	}

	public String getCollectType() {
		return collectType;
	}

	public void setCollectType(String collectType) {
		this.collectType = collectType;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Boolean getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(Boolean deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public Double getValuePerUnitCollect() {
		return valuePerUnitCollect;
	}

	public void setValuePerUnitCollect(Double valuePerUnitCollect) {
		this.valuePerUnitCollect = valuePerUnitCollect;
	}

	public Double getTotalToReceive() {
		return totalToReceive;
	}

	public void setTotalToReceive(Double totalToReceive) {
		this.totalToReceive = totalToReceive;
	}

	public Double getValueToPayPerUnit() {
		return valueToPayPerUnit;
	}

	public void setValueToPayPerUnit(Double valueToPayPerUnit) {
		this.valueToPayPerUnit = valueToPayPerUnit;
	}

	public Double getTotalValueToPay() {
		return totalValueToPay;
	}

	public void setTotalValueToPay(Double totalValueToPay) {
		this.totalValueToPay = totalValueToPay;
	}
	
	

}
