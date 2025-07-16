package com.curso.modelo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.curso.modelo.entidad.Pelicula;
import com.curso.persistencia.PeliculaDao;
import com.curso.util.Logger;

/*
<bean id="servicioPeliculas" class="com.curso.modelo.ServicioPeliculas" scope="singleton" lazy-init="false">

</bean>
*/
//@Service
public class ServicioPeliculas {
	
	//@Autowired
	private PeliculaDao peliculaDao;
	
	//@Autowired 
	private Logger log;
	//@Autowired 
	private Logger logError;
	
	public ServicioPeliculas() {
		super();
		System.out.println("Creando un ServicioPeliculas");
	}

	//Estos setters estyán aqui por que hemos registrado la bean 'servicioPeliculas' en java config
	//por capricho
	public void setPeliculaDao(PeliculaDao peliculaDao) {
		this.peliculaDao = peliculaDao;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	public void setLogError(Logger logError) {
		this.logError = logError;
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


