package com.curso.modelo.entidad;

//Clase de acceso publico
//No tiene anotación alguna
public class ClienteResumen {

	private Integer id;
	private String nombre;
	private String direccion;

	//No es necesario el constructor por defecto
	
	//Novedad: nos exige un constructor con parametros siendo el por defecto opcional
	public ClienteResumen(Integer id, String nombre, String direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
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
	
	
}
