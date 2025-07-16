package com.curso.modelo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.curso.modelo.entidad.Pelicula;
import com.curso.persistencia.PeliculaDao;
import com.curso.util.Logger;

@Service
public class ServicioPeliculas {
	
	@Autowired
	private PeliculaDao peliculaDao;
	
	@Autowired 
	private Logger log;
	@Autowired 
	private Logger logError;
	
	public ServicioPeliculas() {
		super();
		System.out.println("Creando un ServicioPeliculas");
	}

	public void insertar(Pelicula pelicula){
		//LN
		//...
		log.escribir("Insertando una pelicula");
		logError.escribir("Error insertando una pelicula");
		
		peliculaDao.insertar(pelicula);		
	}
	
	//modificarPelicula
	//listarPeliculas
	//borrarPelicula...
	
}


