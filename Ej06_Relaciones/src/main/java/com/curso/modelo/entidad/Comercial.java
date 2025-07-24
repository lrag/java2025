package com.curso.modelo.entidad;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Comercial {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;

	@ManyToMany(cascade=CascadeType.ALL) //Este cascade es una aberracion
	@JoinTable(name="comerciales_clientes",
			   joinColumns= { @JoinColumn(name="fk_id_comercial", referencedColumnName="id") }, //FK que aporta Comercial
			   inverseJoinColumns= { @JoinColumn(name="fk_id_cliente", referencedColumnName="id")}) //FKs que aportan el resto de entidades
	private List<Cliente> clientes;

	public Comercial() {
		super();
	}

	public Comercial(Integer id, String nombre, List<Cliente> clientes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.clientes = clientes;
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

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}
