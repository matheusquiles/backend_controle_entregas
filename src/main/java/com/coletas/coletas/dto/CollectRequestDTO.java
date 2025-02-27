package com.coletas.coletas.dto;

import java.time.LocalDate;

public class CollectRequestDTO {
	private String userKey;
    private LocalDate initialDate;
    private LocalDate finalDate;

    public String getUserKey() {
        return userKey;
    }
    
    public CollectRequestDTO(String userKey, LocalDate initialDate, LocalDate finalDate) {
		super();
		this.userKey = userKey;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
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

}
