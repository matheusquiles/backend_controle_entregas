package com.coletas.coletas.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class CollectItens implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCollectItens;
	
	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name = "collect", nullable=false)
	private Collect collect;
	
	@OneToOne()
	@JoinColumn(name = "collect_type")
	private CollectType collectType;
	
	private Integer quantity;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate date;
	private Boolean deliverStatus;
	private LocalDateTime creationDate;
	private LocalDateTime lastModificatinDate;
	
	@OneToOne()
	@JoinColumn(name = "created_by")
	private Users createdBy;
	
	@OneToOne()
	@JoinColumn(name = "last_modification_by")
	private Users lastModificationBy;
	
	public CollectItens() {
	}

	public CollectItens(Collect collect, CollectType collectType, Integer quantity, LocalDate date,
			Boolean deliverStatus) {
		super();
		this.collect = collect;
		this.collectType = collectType;
		this.quantity = quantity;
		this.date = date;
		this.deliverStatus = deliverStatus;
	}

	public Integer getIdCollectItens() {
		return idCollectItens;
	}

	public void setIdCollectItens(Integer idCollectItens) {
		this.idCollectItens = idCollectItens;
	}

	public Collect getCollect() {
		return collect;
	}

	public void setCollect(Collect collect) {
		this.collect = collect;
	}

	public CollectType getCollectType() {
		return collectType;
	}

	public void setCollectType(CollectType collectType) {
		this.collectType = collectType;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Boolean getDeliverStatus() {
		return deliverStatus;
	}

	public void setDeliverStatus(Boolean deliverStatus) {
		this.deliverStatus = deliverStatus;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDateTime getLastModificatinDate() {
		return lastModificatinDate;
	}

	public void setLastModificatinDate(LocalDateTime lastModificatinDate) {
		this.lastModificatinDate = lastModificatinDate;
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

	@Override
	public int hashCode() {
		return Objects.hash(idCollectItens);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CollectItens other = (CollectItens) obj;
		return Objects.equals(idCollectItens, other.idCollectItens);
	}

	@Override
	public String toString() {
		return "CollectItens [idCollectItens=" + idCollectItens + ", collect=" + collect + ", collectType="
				+ collectType + ", quantity=" + quantity + ", date=" + date + ", deliverStatus=" + deliverStatus
				+ ", creationDate=" + creationDate + ", lastModificatinDate=" + lastModificatinDate + ", createdBy="
				+ createdBy + ", lastModificationBy=" + lastModificationBy + "]";
	}

	
	
}
