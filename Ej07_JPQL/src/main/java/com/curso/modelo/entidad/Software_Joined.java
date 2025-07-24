package com.curso.modelo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="software_joined")
public class Software_Joined extends Producto_Joined {

	protected String tecnologia;
	
	public Software_Joined() {
		super();
	}

	public Software_Joined(int idProducto, String nombre, String descripcion,
			String tecnologia) {
		super(idProducto, nombre, descripcion);
		this.tecnologia = tecnologia;
	}

	public String getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}

	@Override
	public String toString() {
		return "Software [tecnologia=" + tecnologia + ", idProducto="
				+ idProducto + ", nombre=" + nombre + ", descripcion="
				+ descripcion + "]";
	}

}
