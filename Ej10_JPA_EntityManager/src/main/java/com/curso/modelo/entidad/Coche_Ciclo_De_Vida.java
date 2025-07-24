package com.curso.modelo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Transient;

@Entity
public class Coche_Ciclo_De_Vida {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String marca;
	private String modelo;
	private String matricula;
	
	@PostLoad
	public void postLoad() {
		System.out.println("POSTLOAD");
	}

	@PrePersist
	public void prePersist() {
		System.out.println("PREPERSIST");
	}

	@PostPersist
	public void postPersist() {
		System.out.println("POSTPERSIST");
	}

	@PreUpdate
	public void preUpdate() {
		System.out.println("PREUPDATE");
	}

	@PostUpdate
	public void postUpdate() {
		System.out.println("POSTUPDATE");
	}

	@PreRemove
	public void preRemove() {
		System.out.println("PREREMOVE");
	}

	@PostRemove
	public void postRemove() {
		System.out.println("POSTREMOVE");
	}

	public Coche_Ciclo_De_Vida() {
		super();
	}

	public Coche_Ciclo_De_Vida(Integer id, String marca, String modelo, String matricula) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.matricula = matricula;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

}
