package com.coletas.coletas.model;

public class DeliveryPreValue {
	
	private DeliveryRegion deliveryRegion;
	private Users motoboy;
	private Double preValue;
	
	public DeliveryPreValue() {
	}

	public DeliveryPreValue(DeliveryRegion deliveryRegion, Users motoboy, Double value) {
		super();
		this.deliveryRegion = deliveryRegion;
		this.motoboy = motoboy;
		this.preValue = value;
	}

	public DeliveryRegion getDeliveryRegion() {
		return deliveryRegion;
	}

	public void setDeliveryRegion(DeliveryRegion deliveryRegion) {
		this.deliveryRegion = deliveryRegion;
	}

	public Users getMotoboy() {
		return motoboy;
	}

	public void setMotoboy(Users motoboy) {
		this.motoboy = motoboy;
	}

	public Double getPreValue() {
		return preValue;
	}

	public void setPreValue(Double preValue) {
		this.preValue = preValue;
	}
	
}
