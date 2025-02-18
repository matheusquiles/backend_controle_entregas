package com.coletas.coletas.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;

@Entity
public class Collect implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCollect;
	
	private String collectKey;
	
	@OneToOne()
	@JoinColumn(name = "user_id")
	private Users userId;
	
	@OneToOne()
	@JoinColumn(name = "edress")
	private Edress edress;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate date;
	private Boolean status;
	private LocalDateTime creationDate;
	private LocalDateTime lastModificationDate;
	
	@OneToOne()
	@JoinColumn(name = "created_by")
	private Users createdBy;
	
	@OneToOne()
	@JoinColumn(name = "last_modification_by")
	private Users lastModificationBy;
	
	@Transient
	private List<CollectItens> itens;
	
	public Collect() {
	}

	public Collect(Users userId, LocalDate date, Boolean status, Edress edress, List<CollectItens> itens) {
		super();
		this.userId = userId;
		this.date = date;
		this.status = status;
		this.edress = edress;
		this.itens = itens;
	}

	public Integer getIdCollect() {
		return idCollect;
	}

	public void setIdCollect(Integer idCollect) {
		this.idCollect = idCollect;
	}

	public Users getUserId() {
		return userId;
	}

	public void setUserId(Users userId) {
		this.userId = userId;
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

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDateTime getLastModificationDate() {
		return lastModificationDate;
	}

	public void setLastModificationDate(LocalDateTime lastModificatinDate) {
		this.lastModificationDate = lastModificatinDate;
	}

	public Users getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Users createdBy) {
		this.createdBy = createdBy;
	}

	public Users getLastModificationBy() {
		return lastModificationBy;
	}

	public void setLastModificationBy(Users lastModificationBy) {
		this.lastModificationBy = lastModificationBy;
	}

	public List<CollectItens> getItens() {
		return itens;
	}

	public void setItens(List<CollectItens> itens) {
		this.itens = itens;
	}
	
	public Edress getEdress() {
		return edress;
	}

	public void setEdress(Edress edress) {
		this.edress = edress;
	}

	public String getCollectKey() {
		return collectKey;
	}

	public void setCollectKey(String collectKey) {
		this.collectKey = collectKey;
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Collect other = (Collect) obj;
		return Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "Collect [idCollect=" + idCollect + ", userId=" + userId + ", date=" + date + ", status=" + status
				+ ", creationDate=" + creationDate + ", lastModificatinDate=" + lastModificationDate + ", createdBy="
				+ createdBy + ", lastModificationBy=" + lastModificationBy + ", itens=" + itens + "]";
	}
	
	
	
	

}
