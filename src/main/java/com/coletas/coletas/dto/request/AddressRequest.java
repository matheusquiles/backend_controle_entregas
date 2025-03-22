package com.coletas.coletas.dto.request;

public class AddressRequest {
	
	private String description;
	private String edress;
	private Boolean status;
	
	public AddressRequest() {
	}
	
	public AddressRequest(String description, String edress, Boolean status) {
		super();
		this.description = description;
		this.edress = edress;
		this.status = status;
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

}
