package com.curso.modelo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="consultoria_joined")
public class Consultoria_Joined extends Producto_Joined {

	protected int precioPorCabeza;

	public Consultoria_Joined() {
		super();
	}

	public Consultoria_Joined(int idProducto, String nombre, String descripcion,
			int precioPorCabeza) {
		super(idProducto, nombre, descripcion);
		this.precioPorCabeza = precioPorCabeza;
	}

	public int getPrecioPorCabeza() {
		return precioPorCabeza;
	}

	public void setPrecioPorCabeza(int precioPorCabeza) {
		this.precioPorCabeza = precioPorCabeza;
	}

	@Override
	public String toString() {
		return "Consultoria [precioPorCabeza=" + precioPorCabeza
				+ ", idProducto=" + idProducto + ", nombre=" + nombre
				+ ", descripcion=" + descripcion + "]";
	}

}
