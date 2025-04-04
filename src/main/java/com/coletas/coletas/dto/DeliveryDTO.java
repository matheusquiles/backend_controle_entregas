package com.coletas.coletas.dto;

import java.time.LocalDate;
import java.util.List;

public class DeliveryDTO {

	private Integer idDelivery;
	private String deliveryKey;
	private Double value;
	private Integer idMotoboy;
	private String nameMotoboy;
	private Integer idCoordinator;
	private String nameCoordinator;
	private Integer idDeliveryRegion;
	private String deliveryRegion;
	private LocalDate date;
	private Boolean status;
	private String deliveryStatus;
	
	private List<DeliveryItemsDTO> deliveryItemDTO;
	
	
	public DeliveryDTO() {
	}


	public DeliveryDTO(Integer idDelivery, String deliveryKey, Double value, Integer idMotoboy, String nameMotoboy,
			Integer idCoordinator, String nameCoordinator, Integer idDeliveryRegion, String deliveryRegion,
			LocalDate date, Boolean status, String deliveryStatus, List<DeliveryItemsDTO> deliveryItemDTO) {
		super();
		this.idDelivery = idDelivery;
		this.deliveryKey = deliveryKey;
		this.value = value;
		this.idMotoboy = idMotoboy;
		this.nameMotoboy = nameMotoboy;
		this.idCoordinator = idCoordinator;
		this.nameCoordinator = nameCoordinator;
		this.idDeliveryRegion = idDeliveryRegion;
		this.deliveryRegion = deliveryRegion;
		this.date = date;
		this.status = status;
		this.deliveryStatus = deliveryStatus;
		this.deliveryItemDTO = deliveryItemDTO;
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

	public Integer getIdMotoboy() {
		return idMotoboy;
	}

	public void setIdMotoboy(Integer idMotoboy) {
		this.idMotoboy = idMotoboy;
	}

	public String getNameMotoboy() {
		return nameMotoboy;
	}

	public void setNameMotoboy(String nameMotoboy) {
		this.nameMotoboy = nameMotoboy;
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

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}


	public Integer getIdCoordinator() {
		return idCoordinator;
	}


	public void setIdCoordinator(Integer idCoordinator) {
		this.idCoordinator = idCoordinator;
	}


	public String getNameCoordinator() {
		return nameCoordinator;
	}


	public void setNameCoordinator(String nameCoordinator) {
		this.nameCoordinator = nameCoordinator;
	}


	public List<DeliveryItemsDTO> getDeliveryItemDTO() {
		return deliveryItemDTO;
	}


	public void setDeliveryItemDTO(List<DeliveryItemsDTO> deliveryItemDTO) {
		this.deliveryItemDTO = deliveryItemDTO;
	}
	
	
}
