package com.coletas.coletas.dto;

import java.time.LocalDate;

public class CollectRequestDTO {
	private Integer idUser;
    private LocalDate initialDate;
    private LocalDate finalDate;
    private Integer idSupervisor;
    private Integer idEdress;
    private String deliveryStatus;
    
    public CollectRequestDTO() {
	}

    
    public CollectRequestDTO(Integer idUser, LocalDate initialDate, LocalDate finalDate) {
		super();
		this.idUser = idUser;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
	}
    
	public CollectRequestDTO(Integer idUser, LocalDate initialDate, LocalDate finalDate, Integer idEdress) {
		super();
		this.idUser = idUser;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.idEdress = idEdress;
	}

	public CollectRequestDTO(Integer idUser, LocalDate initialDate, LocalDate finalDate, Integer idSupervisor,
			Integer idEdress) {
		super();
		this.idUser = idUser;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.idSupervisor = idSupervisor;
		this.idEdress = idEdress;
	}
	

    public CollectRequestDTO(Integer idUser, LocalDate initialDate, LocalDate finalDate, Integer idSupervisor,
			Integer idEdress, String deliveryStatus) {
		super();
		this.idUser = idUser;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.idSupervisor = idSupervisor;
		this.idEdress = idEdress;
		this.deliveryStatus = deliveryStatus;
	}


	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
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

	public Integer getIdSupervisor() {
		return idSupervisor;
	}

	public void setIdSupervisor(Integer idSupervisor) {
		this.idSupervisor = idSupervisor;
	}

	public Integer getIdEdress() {
		return idEdress;
	}

	public void setIdEdress(Integer idEdress) {
		this.idEdress = idEdress;
	}


	public String getDeliveryStatus() {
		return deliveryStatus;
	}


	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
    
    

}
