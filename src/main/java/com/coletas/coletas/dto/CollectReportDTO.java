package com.coletas.coletas.dto;

import java.time.LocalDate;
import java.util.List;

public class CollectReportDTO {
	
	private LocalDate date;
	private Long total;
	private Double totalValue;
	
	private List<CollectTypeReportDTO> byType;
	
	public CollectReportDTO() {
	}
	
	public CollectReportDTO(LocalDate date, Long total, Double totalValue) {
		super();
		this.date = date;
		this.total = total;
		this.totalValue = totalValue;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public List<CollectTypeReportDTO> getByType() {
		return byType;
	}

	public void setByType(List<CollectTypeReportDTO> byType) {
		this.byType = byType;
	}
	
	

}
