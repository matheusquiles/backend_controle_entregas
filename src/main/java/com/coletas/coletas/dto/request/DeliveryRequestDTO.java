package com.coletas.coletas.dto.request;

import java.time.LocalDate;

public class DeliveryRequestDTO {
	
	private Integer idMotoboy;
	private Integer idCoordinator;
    private LocalDate initialDate;
    private LocalDate finalDate;
    private Integer idDeliveryRegion;
    private String deliveryStatus;
    
    
    public DeliveryRequestDTO() {
	}


	public DeliveryRequestDTO(Integer idMotoboy, Integer idCoordinator, LocalDate initialDate, LocalDate finalDate,
			Integer idDeliveryRegion, String deliveryStatus) {
		super();
		this.idMotoboy = idMotoboy;
		this.idCoordinator = idCoordinator;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.idDeliveryRegion = idDeliveryRegion;
		this.deliveryStatus = deliveryStatus;
	}


	public Integer getIdMotoboy() {
		return idMotoboy;
	}


	public void setIdMotoboy(Integer idMotoboy) {
		this.idMotoboy = idMotoboy;
	}


	public Integer getIdCoordinator() {
		return idCoordinator;
	}


	public void setIdCoordinator(Integer idCoordinator) {
		this.idCoordinator = idCoordinator;
	}


	public LocalDate getInitialDate() {
		return initialDate;
	}


	public void setInitialDate(LocalDate initialDate) {
		this.initialDate = initialDate;
	}


	public LocalDate getFinalDate() {
		return finalDate;
	}


	public void setFinalDate(LocalDate finalDate) {
		this.finalDate = finalDate;
	}


	public Integer getIdDeliveryRegion() {
		return idDeliveryRegion;
	}


	public void setIdDeliveryRegion(Integer idDeliveryRegion) {
		this.idDeliveryRegion = idDeliveryRegion;
	}


	public String getDeliveryStatus() {
		return deliveryStatus;
	}


	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

    
}
