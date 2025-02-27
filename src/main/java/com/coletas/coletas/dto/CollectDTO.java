package com.coletas.coletas.dto;

import java.time.LocalDate;
import java.util.List;

import com.coletas.coletas.model.Users;

public class CollectDTO {
	
	private Integer idCollect;
	private String collectKey;
	private String collectUser;
	private String edress;
	private String edressDescription;
	private LocalDate date;
	private Boolean status;
	
	private List<CollectItensDTO> itens;
	
	public CollectDTO() {
	}


	public CollectDTO(Integer idCollect, String collectKey, String collectUser, String edress, String edressDescription,
			LocalDate date, Boolean status, List<CollectItensDTO> itens) {
		super();
		this.idCollect = idCollect;
		this.collectKey = collectKey;
		this.collectUser = collectUser;
		this.edress = edress;
		this.edressDescription = edressDescription;
		this.date = date;
		this.status = status;
		this.itens = itens;
	}

	public String getCollectUser() {
		return collectUser;
	}

	public void setCollectUser(String collectUser) {
		this.collectUser = collectUser;
	}

	public Integer getIdCollect() {
		return idCollect;
	}

	public void setIdCollect(Integer idCollect) {
		this.idCollect = idCollect;
	}

	public String getCollectKey() {
		return collectKey;
	}

	public void setCollectKey(String collectKey) {
		this.collectKey = collectKey;
	}


	public String getEdress() {
		return edress;
	}

	public void setEdress(String edress) {
		this.edress = edress;
	}

	public String getEdressDescription() {
		return edressDescription;
	}

	public void setEdressDescription(String edressDescription) {
		this.edressDescription = edressDescription;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public List<CollectItensDTO> getItens() {
		return itens;
	}

	public void setItens(List<CollectItensDTO> itens) {
		this.itens = itens;
	}

	@Override
	public String toString() {
		return "CollectDTO [collectKey=" + collectKey + ", collectUser=" + collectUser + ", edress=" + edress
				+ ", edressDescription=" + edressDescription + ", date=" + date + ", status=" + status + ", itens="
				+ itens + "]";
	}
	

}
