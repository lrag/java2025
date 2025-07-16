package com.curso.modelo.negocio;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.curso.modelo.entidad.Pelicula;
import com.curso.persistencia.PeliculaDao;

public class ServicioPeliculas {
	
	//Dependencia
	private PeliculaDao peliculaDao;
	
	public ServicioPeliculas() {
		super();
		System.out.println("Creando un ServicioPeliculas");
	}

	public void setPeliculaDao(PeliculaDao peliculaDao) {
		this.peliculaDao = peliculaDao;
	}

	public void insertar(Pelicula pelicula){
		//LN
		//...
		peliculaDao.insertar(pelicula);		
	}
	
	//modificarPelicula
	//listarPeliculas
	//borrarPelicula...
	
}



class Factura {
	
	//ATRIBUTOS
	private String fecha;
	private String codigo;	
	
	//PROPIEDADES
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getCodigo() {
		return codigo;
	}
	
	public Double getTotal() {
		//recorrer los detalles
		//calcular el total
		return 0d;
	}
	
}

class Borrar {
	
	public static void main(String[] args) {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:h2:C:/H2/bbdd_peliculas_2025");
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		
		PeliculaDao peliculaDao = new PeliculaDao();
		peliculaDao.setDataSource(dataSource);
		
		ServicioPeliculas servicioPeliculas = new ServicioPeliculas();
		servicioPeliculas.setPeliculaDao(peliculaDao);
		
	}
	
}














