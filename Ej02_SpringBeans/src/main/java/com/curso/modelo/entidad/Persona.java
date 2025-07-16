package com.curso.modelo.entidad;

import java.util.Map;

public class Persona extends AbstractBean {

	private String nombre;
	private String fechaNac;
	private String direccion;
	private int codigo;
	private Map<String, Mascota> mascotas;
	
	public Persona() {
		super();
		System.out.println("Creando persona:"+this);
	}

	public Persona(String nombre, String fechaNac, String direccion, int codigo) {
		super();
		System.out.println("Creando persona:"+this);
		this.nombre = nombre;
		this.fechaNac = fechaNac;
		this.direccion = direccion;
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Map<String, Mascota> getMascotas() {
		return mascotas;
	}

	public void setMascotas(Map<String, Mascota> mascotas) {
		this.mascotas = mascotas;
	}
	
}
