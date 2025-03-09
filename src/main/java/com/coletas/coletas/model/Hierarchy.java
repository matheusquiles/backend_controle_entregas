package com.coletas.coletas.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "hierarchy")
public class Hierarchy implements Serializable{
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hierarchy")
    private Integer idHierarchy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_motoboy", nullable = false)
    private Users motoboy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_coordinator", nullable = false)
    private Users coordinator;
    
    public Hierarchy() {
	}

	public Hierarchy(Integer idHierarchy, Users motoboy, Users coordinator) {
		super();
		this.idHierarchy = idHierarchy;
		this.motoboy = motoboy;
		this.coordinator = coordinator;
	}

	public Hierarchy(Users motoboy, Users coordinator) {
		super();
		this.motoboy = motoboy;
		this.coordinator = coordinator;
	}
	

	public Hierarchy(Users coordinator) {
		super();
		this.coordinator = coordinator;
	}

	public Integer getIdHierarchy() {
		return idHierarchy;
	}

	public void setIdHierarchy(Integer idHierarchy) {
		this.idHierarchy = idHierarchy;
	}

	public Users getMotoboy() {
		return motoboy;
	}

	public void setMotoboy(Users motoboy) {
		this.motoboy = motoboy;
	}

	public Users getCoordinator() {
		return coordinator;
	}

	public void setCoordinator(Users coordinator) {
		this.coordinator = coordinator;
	}




}
