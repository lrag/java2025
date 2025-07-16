package com.curso.modelo.entidad;

public class Mascota extends AbstractBean{

	private String tipoBicho = "";
	private String nombre    = "";
	
	public Mascota() {		
		super();
	}

	public Mascota(String tipoBicho, String nombre) {
		super();
		this.tipoBicho = tipoBicho;
		this.nombre = nombre;
	}

	public String getTipoBicho() {
		return tipoBicho;
	}

	public void setTipoBicho(String tipoBicho) {
		this.tipoBicho = tipoBicho;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
	
}
