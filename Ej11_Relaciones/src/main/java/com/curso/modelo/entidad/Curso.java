package com.curso.modelo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/*

ID  NOMBRE FK_ID_AULA_TEORIA  FK_ID_AULA_PRACTICA
-------------------------------------------------

*/

@Entity
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_aula_teoria")
	private Aula aulaTeoria;
	@ManyToOne
	@JoinColumn(name = "fk_id_aula_practica")
	private Aula aulaPractica;

	public Curso() {
		super();
	}

	public Curso(Integer id, String nombre, Aula aulaTeoria, Aula aulaPractica) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.aulaTeoria = aulaTeoria;
		this.aulaPractica = aulaPractica;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Aula getAulaTeoria() {
		return aulaTeoria;
	}

	public void setAulaTeoria(Aula aulaTeoria) {
		this.aulaTeoria = aulaTeoria;
	}

	public Aula getAulaPractica() {
		return aulaPractica;
	}

	public void setAulaPractica(Aula aulaPractica) {
		this.aulaPractica = aulaPractica;
	}

}
