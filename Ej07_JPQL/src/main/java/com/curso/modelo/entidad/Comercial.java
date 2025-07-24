package com.curso.modelo.entidad;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Comercial {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;

	@ManyToMany(mappedBy="comerciales", cascade={CascadeType.ALL})	
	private List<Cliente> clientes;

	public Comercial() {
		super();
	}

	public Comercial(int idComercial, String nombre, List<Cliente> clientes) {
		super();
		this.id = idComercial;
		this.nombre = nombre;
		this.clientes = clientes;
	}

	public int getId() {
		return id;
	}

	public void setId(int idComercial) {
		this.id = idComercial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}
