package com.coletas.coletas.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CollectPreValue implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCollectPreValue;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "edress", nullable = false)
	private Edress edress;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "collect_type", nullable = false)
	private CollectType collectType;
	private Double preValue;
	
	public Edress getEdress() {
		return edress;
	}
	
	public CollectPreValue() {
	}
	
	public CollectPreValue(Edress edress, CollectType collectType, Double preValue) {
		super();
		this.edress = edress;
		this.collectType = collectType;
		this.preValue = preValue;
	}

	public Integer getIdCollectPreValue() {
		return idCollectPreValue;
	}

	public void setIdCollectPreValue(Integer idCollectPreValue) {
		this.idCollectPreValue = idCollectPreValue;
	}

	public void setEdress(Edress edress) {
		this.edress = edress;
	}
	public CollectType getCollectType() {
		return collectType;
	}
	public void setCollectType(CollectType collectType) {
		this.collectType = collectType;
	}
	public Double getPreValue() {
		return preValue;
	}
	public void setPreValue(Double preValue) {
		this.preValue = preValue;
	}

	@Override
	public String toString() {
		return "CollectPreValue [idCollectPreValue=" + idCollectPreValue + ", edress=" + edress + ", collectType="
				+ collectType + ", preValue=" + preValue + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCollectPreValue);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CollectPreValue other = (CollectPreValue) obj;
		return Objects.equals(idCollectPreValue, other.idCollectPreValue);
	}

}
