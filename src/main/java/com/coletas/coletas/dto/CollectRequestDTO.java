package com.coletas.coletas.dto;

import java.time.LocalDate;

public class CollectRequestDTO {
	private String userKey;
    private LocalDate initialDate;
    private LocalDate finalDate;
    private Integer idSupervisor;
    private Integer idEdress;
    
    public CollectRequestDTO() {
	}

    public String getUserKey() {
        return userKey;
    }
    
    public CollectRequestDTO(String userKey, LocalDate initialDate, LocalDate finalDate) {
		super();
		this.userKey = userKey;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
	}
    
	public CollectRequestDTO(String userKey, LocalDate initialDate, LocalDate finalDate, Integer idEdress) {
		super();
		this.userKey = userKey;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.idEdress = idEdress;
	}

	public CollectRequestDTO(String userKey, LocalDate initialDate, LocalDate finalDate, Integer idSupervisor,
			Integer idEdress) {
		super();
		this.userKey = userKey;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.idSupervisor = idSupervisor;
		this.idEdress = idEdress;
	}

	public void setUserKey(String userKey) {
        this.userKey = userKey;
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
    
    

}
