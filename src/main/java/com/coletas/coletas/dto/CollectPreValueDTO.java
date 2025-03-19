package com.coletas.coletas.dto;

public class CollectPreValueDTO {
	
	private Integer idCollectPreValue;
	private Integer idEdress;
	private String edress;
	private Integer idCollectType;
	private String collectType;
	private Double preValue;
	
	
	public CollectPreValueDTO() {
	}
	
	public CollectPreValueDTO(Integer idCollectPreValue, Integer idEdress, String edress, Integer idCollectType,
			String collectType, Double preValue) {
		super();
		this.idCollectPreValue = idCollectPreValue;
		this.idEdress = idEdress;
		this.edress = edress;
		this.idCollectType = idCollectType;
		this.collectType = collectType;
		this.preValue = preValue;
	}
	

	public CollectPreValueDTO(Double preValue) {
		super();
		this.preValue = preValue;
	}

	public Integer getIdCollectPreValue() {
		return idCollectPreValue;
	}


	public void setIdCollectPreValue(Integer idCollectPreValue) {
		this.idCollectPreValue = idCollectPreValue;
	}


	public Integer getIdEdress() {
		return idEdress;
	}


	public void setIdEdress(Integer idEdress) {
		this.idEdress = idEdress;
	}


	public String getEdress() {
		return edress;
	}


	public void setEdress(String edress) {
		this.edress = edress;
	}


	public Integer getIdCollectType() {
		return idCollectType;
	}


	public void setIdCollectType(Integer idCollectType) {
		this.idCollectType = idCollectType;
	}


	public String getCollectType() {
		return collectType;
	}


	public void setCollectType(String collectType) {
		this.collectType = collectType;
	}


	public Double getPreValue() {
		return preValue;
	}


	public void setPreValue(Double preValue) {
		this.preValue = preValue;
	}

	
	
	
}
