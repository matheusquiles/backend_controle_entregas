package com.coletas.coletas.dto;

import java.time.LocalDate;
import java.util.List;

public class DeliveryReportDTO {

	private LocalDate date;
	private Long total;
	private Double totalValue;
	private List<RegionDeliveryReportDTO> byRegion;
	
	public DeliveryReportDTO() {
	}
	
	public DeliveryReportDTO(LocalDate date, Long total, Double totalValue) {
		super();
		this.date = date;
		this.total = total;
		this.totalValue = totalValue;
	}

	public List<RegionDeliveryReportDTO> getByRegion() {
		return byRegion;
	}

	public void setByRegion(List<RegionDeliveryReportDTO> byRegion) {
		this.byRegion = byRegion;
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
	
}
