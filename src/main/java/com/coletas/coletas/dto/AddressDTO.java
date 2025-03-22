package com.coletas.coletas.dto;

import java.util.List;

public class AddressDTO {

	private Integer idEdress;

	private String description;
	private String edress;
	private Boolean status;

	private List<CollectPreValueDTO> collectPreValue;

	public AddressDTO() {
	}

	public AddressDTO(Integer idEdress, String description, String edress, Boolean status,
			List<CollectPreValueDTO> collectPreValue) {
		super();
		this.idEdress = idEdress;
		this.description = description;
		this.edress = edress;
		this.status = status;
		this.collectPreValue = collectPreValue;
	}

	public Integer getIdEdress() {
		return idEdress;
	}

	public void setIdEdress(Integer idEdress) {
		this.idEdress = idEdress;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEdress() {
		return edress;
	}

	public void setEdress(String edress) {
		this.edress = edress;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public List<CollectPreValueDTO> getCollectPreValue() {
		return collectPreValue;
	}

	public void setCollectPreValue(List<CollectPreValueDTO> collectPreValue) {
		this.collectPreValue = collectPreValue;
	}

	
	
}
