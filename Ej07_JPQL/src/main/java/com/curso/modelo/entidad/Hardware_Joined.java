package com.curso.modelo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="Hardware_joined") //Puede tener table
public class Hardware_Joined extends Producto_Joined {
	//No tiene @Id
	protected double peso;

	public Hardware_Joined() {
		super();
	}

	public Hardware_Joined(int idProducto, String nombre, String descripcion,
			double peso) {
		super(idProducto, nombre, descripcion);
		this.peso = peso;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Hardware [peso=" + peso + ", idProducto=" + idProducto
				+ ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}

}
