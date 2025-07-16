package com.curso.modelo.negocio;

import com.curso.modelo.entidad.Pelicula;
import com.curso.persistencia.PeliculaDao;

public class ServicioPeliculas {

	//SINGLETON//////////////////////////////////////////////////////////
	private static ServicioPeliculas instancia;
	
	public static synchronized ServicioPeliculas getInstancia() {
		//Lazy inicialization
		if(instancia == null) {
			instancia = new ServicioPeliculas();
		}
		return instancia;
	}
	//SINGLETON//////////////////////////////////////////////////////////
	
	private ServicioPeliculas() {
	}		
	
	private PeliculaDao peliculaDao;
	private ServicioActores servicioActores = ServicioActores.getInstancia();
	
	public void altaPelicula(Pelicula pelicula) {
		
		//Validar los datos...
		//Comprobar que el director existe...
		//...
		peliculaDao.insertar(pelicula);
		//...
		
	}
	
}
