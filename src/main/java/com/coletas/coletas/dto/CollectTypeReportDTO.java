package com.coletas.coletas.dto;

public class CollectTypeReportDTO {
	
	private String type;
    private Long quantity;
    private Double value;
    
    public CollectTypeReportDTO() {
	}
 
	public CollectTypeReportDTO(String type, Long quantity, Double value) {
		super();
		this.type = type;
		this.quantity = quantity;
		this.value = value;
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
