package com.coletas.coletas.dto;

import java.time.LocalDate;

public class ReportRequestDTO {

	private Integer idUser;
	private LocalDate date;
	
	public ReportRequestDTO() {
	}
	
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	
}
