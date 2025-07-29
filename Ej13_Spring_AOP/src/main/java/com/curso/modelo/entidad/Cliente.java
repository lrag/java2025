package com.curso.modelo.entidad;

public class Cliente {

	//alt+shift+s c constructor de la superclase
	//alt+shift+s o constructor con parametros
	//alt+shift+s r get/set
	//alt+shift+s s toString
	
	private String nombre;

	public Cliente() {
		super();
	}

	public Cliente(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + "]";
	}	
	
}
