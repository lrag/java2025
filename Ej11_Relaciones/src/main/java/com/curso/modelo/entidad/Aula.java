package com.curso.modelo.entidad;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Aula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String edificio;
	private String codigo;
	
	@OneToMany(mappedBy = "aulaTeoria")
	private List<Curso> cursosTeoricos;
	@OneToMany(mappedBy = "aulaPractica")
	private List<Curso> cursosPracticos;

	public Aula() {
		super();
	}

	public Aula(Integer id, String edificio, String codigo) {
		super();
		this.id = id;
		this.edificio = edificio;
		this.codigo = codigo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEdificio() {
		return edificio;
	}

	public void setEdificio(String edificio) {
		this.edificio = edificio;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
