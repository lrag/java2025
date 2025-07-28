package com.curso.modelo.entidad;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

/*

NOMBRE | APELLIDOS | DATO1 | DATO2
----------------------------------
Ringo    Starr       10      100

*/

@Entity
public class ClaseConClaveCompuesta {

	@EmbeddedId
	private Clave clave;

	private String dato1;
	private String dato2;

	public ClaseConClaveCompuesta() {
		super();
	}

	public ClaseConClaveCompuesta(Clave clave, String dato1, String dato2) {
		super();
		this.clave = clave;
		this.dato1 = dato1;
		this.dato2 = dato2;
	}

	public Clave getClave() {
		return clave;
	}

	public void setClave(Clave clave) {
		this.clave = clave;
	}

	public String getDato1() {
		return dato1;
	}

	public void setDato1(String dato1) {
		this.dato1 = dato1;
	}

	public String getDato2() {
		return dato2;
	}

	public void setDato2(String dato2) {
		this.dato2 = dato2;
	}

}







