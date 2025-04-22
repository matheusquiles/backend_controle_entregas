package com.coletas.coletas.dto;

import java.util.List;

public class RegionDeliveryReportDTO {
	
    private String region;
    private List<DeliveryTypeReportDTO> deliveries;
    
    public RegionDeliveryReportDTO() {
	}

	public RegionDeliveryReportDTO(String region) {
		super();
		this.region = region;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public List<DeliveryTypeReportDTO> getDeliveries() {
		return deliveries;
	}

	public void setDeliveries(List<DeliveryTypeReportDTO> deliveries) {
		this.deliveries = deliveries;
	}
    
    

}
