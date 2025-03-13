package com.coletas.coletas.dto.request;

import java.time.LocalDate;
import java.util.List;

import com.coletas.coletas.dto.CollectItensDTO;

public class CollectEditRequestDTO {
	
	private String collectKey;
	private String collectUser;
	private LocalDate date;
	private String edress;
	private String edressDescription;
	private Integer idCollect;
	private Boolean status;
	private Integer lastModificationBy;
	private List<CollectItensDTO> itens;
	
	public CollectEditRequestDTO() {
	}

	public CollectEditRequestDTO(String collectKey, String collectUser, LocalDate date, String edress,
			String edressDescription, Integer idCollect, Boolean status, List<CollectItensDTO> itens) {
		super();
		this.collectKey = collectKey;
		this.collectUser = collectUser;
		this.date = date;
		this.edress = edress;
		this.edressDescription = edressDescription;
		this.idCollect = idCollect;
		this.status = status;
		this.itens = itens;
	}

	public String getCollectKey() {
		return collectKey;
	}

	public void setCollectKey(String collectKey) {
		this.collectKey = collectKey;
	}

	public String getCollectUser() {
		return collectUser;
	}

	public void setCollectUser(String collectUser) {
		this.collectUser = collectUser;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
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

	public Integer getIdCollect() {
		return idCollect;
	}

	public void setIdCollect(Integer idCollect) {
		this.idCollect = idCollect;
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

	public Integer getLastModificationBy() {
		return lastModificationBy;
	}

	public void setLastModificationBy(Integer lastModificationBy) {
		this.lastModificationBy = lastModificationBy;
	}
	

}
