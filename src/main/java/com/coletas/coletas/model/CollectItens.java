package com.coletas.coletas.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
	
	private String deliveryStatus;
	@Column(updatable = false)
	private LocalDateTime creationDate;
	private LocalDateTime lastModificationDate;
	
	private Double valuePerUnitCollect;
	private Double totalToReceive;
	
	
	@OneToOne()
	@JoinColumn(name = "created_by")
	private Users createdBy;
	
	@OneToOne()
	@JoinColumn(name = "last_modification_by")
	private Users lastModificationBy;
	
	public CollectItens() {
	}

	public CollectItens(Collect collect, CollectType collectType, Integer quantity, LocalDate date,
			String deliverStatus) {
		super();
		this.collect = collect;
		this.collectType = collectType;
		this.quantity = quantity;
		this.deliveryStatus = deliverStatus;
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

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliverStatus) {
		this.deliveryStatus = deliverStatus;
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

	public void setlastmodificationdate(LocalDateTime lastModificatinDate) {
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

	@Override
	public int hashCode() {
		return Objects.hash(idCollectItens);
	}
	
	

	public Double getValuePerUnitCollect() {
		return valuePerUnitCollect;
	}

	public Double getTotalToReceive() {
		return totalToReceive;
	}

	public void setTotalToReceive(Double totalToReceive) {
		this.totalToReceive = totalToReceive;
	}

	public void setValuePerUnitCollect(Double valuePerUnitCollect) {
		this.valuePerUnitCollect = valuePerUnitCollect;
	}

	public void setTotalToReceave(Double totalToReceave) {
		this.totalToReceive = totalToReceave;
	}


	public void setLastModificationDate(LocalDateTime lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
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
				+ collectType + ", quantity=" + quantity + ", deliveryStatus=" + deliveryStatus + ", creationDate="
				+ creationDate + ", lastModificationDate=" + lastModificationDate + ", valuePerUnitCollect="
				+ valuePerUnitCollect + ", totalToReceave=" + totalToReceive + ", createdBy=" + createdBy
				+ ", lastModificationBy=" + lastModificationBy + "]";
	}


	
	
}
