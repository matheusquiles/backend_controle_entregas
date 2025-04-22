package com.coletas.coletas.dto;

public class RegionTypeProjection {
	
    private String region;
    private String type;
    private Long quantity;
    private Double value;

    public RegionTypeProjection(String region, String type, Long quantity, Double value) {
        this.region = region;
        this.type = type;
        this.quantity = quantity;
        this.value = value;
    }
    
    public RegionTypeProjection() {
	}
    
    

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
    
    

}
