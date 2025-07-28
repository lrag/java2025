package com.curso.modelo.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

//No es una entidad
//No tiene @Table 
@Embeddable
public class Direccion {
	//No tiene id
	private String ciudad;
	private String calle;
	private String numero;
	@Column(name="codigo_postal")
	private String codigoPostal;

	public Direccion() {
		super();
	}

	public Direccion(String ciudad, String calle, String numero,
			String codigoPostal) {
		super();
		this.ciudad = ciudad;
		this.calle = calle;
		this.numero = numero;
		this.codigoPostal = codigoPostal;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

}
