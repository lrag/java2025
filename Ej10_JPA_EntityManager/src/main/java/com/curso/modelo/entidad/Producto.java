package com.curso.modelo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.TableGenerator;

/*

TABLA_IDS

ID | ENTIDAD  | VALOR
--------------------
1  | Producto | 1
2  | Cliente  | 10

*/

@Entity
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "idProductoGenerator")
    //select VALOR from TABLA_IDS where ENTIDAD='Producto'
	@TableGenerator(
            name="idProductoGenerator", 
            table="TABLA_IDS", 
            pkColumnName="ENTIDAD", 
            valueColumnName="VALOR", 
            pkColumnValue="Producto", 
            allocationSize=1
    	)	
	private Integer id;
	private String nombre;
	private String fabricante;
	private Double precio;

	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Producto(Integer id, String nombre, String fabricante, Double precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fabricante = fabricante;
		this.precio = precio;
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

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", fabricante=" + fabricante + ", precio=" + precio + "]";
	}
	
}
