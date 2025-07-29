package com.curso.modelo.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //Obligatoria
@Table(name="clientes")
public class Cliente {

	@Id //Obligatoria
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String direccion;
	private String telefono;
	@Column(name="numero_tc")
	private Integer numeroTC;

	public Cliente() {
		super();
	}

	public Cliente(Integer id, String nombre, String direccion, String telefono, Integer numeroTC) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.numeroTC = numeroTC;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getNumeroTC() {
		return numeroTC;
	}

	public void setNumeroTC(Integer numeroTC) {
		this.numeroTC = numeroTC;
	}

	@Override
	public boolean equals(Object otro) {		
		if( !(otro instanceof Cliente) ) {
			return false;
		}
		
		Cliente otroCliente = (Cliente) otro;
		return id == otroCliente.id;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", numeroTC=" + numeroTC + "]";
	}	
	
}
