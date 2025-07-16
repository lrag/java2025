package com.curso.modelo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.curso.modelo.entidad.Pelicula;
import com.curso.persistencia.PeliculaDao;
import com.curso.util.Logger;

/*
ESTEREOTIPOS

@Service    : Se utiliza en clases con lógica de negocio
@Repository : Se utiliza en clases que trabajan con la base de datos y son propensas de lanzar excepciones relacionadas con ello
@Component  : Se utiliza cuando la clase no entra en ninguna otra categoría

//Si tenemos Spring MVC se añaden:
@Controller
@RestController

////////////////////////////////////////////////////////////

@Service 
public class ServicioPeliculas {

EQUIVALE A:

<bean id="servicioPeliculas" class="com.curso.modelo.negocio.ServicioPeliculas" scope="singleton" lazy-init="false">

////////////////////////////////////////////////////////////

@Service("servPeliculas")
public class ServicioPeliculas {

EQUIVALE A:

<bean id="servPeliculas" class="com.curso.modelo.negocio.ServicioPeliculas" scope="singleton" lazy-init="false">

////////////////////////////////////////////////////////////

@Service
@Scope("prototype")
public class ServicioPeliculas {

EQUIVALE A:

<bean id="servicioPeliculas" class="com.curso.modelo.negocio.ServicioPeliculas" scope="prototype">

////////////////////////////////////////////////////////////

@Service
@LA
public class ServicioPeliculas {

EQUIVALE A:

<bean id="servicioPeliculas" class="com.curso.modelo.negocio.ServicioPeliculas" scope="prototype">

////////////////////////////////////////////////////////////

@Service
@Lazy
public class ServicioPeliculas {
	
EQUIVALE A:

<bean id="servicioPeliculas" class="com.curso.modelo.negocio.ServicioPeliculas" scope="singleton" lazy-init="TRUE"/>	

*/

@Service
public class ServicioPeliculas {
	
	//@Autowired puede ir en el atributo/campo
	@Autowired
	//Por defecto el autowiring es byType
	private PeliculaDao peliculaDao;
	
	//Como hay declaradas dos definiciones de bean del tipo Logger aqui no sabría cuál escoger -> ZASCA!
	//Cuando no se puede por tipo hay que hacerlo byName
	//Pero desde Spring 4 la anotación Qualifier no es necesaria si el nombre del atributo 
	//coincide con el de la definición de bean que queremos que se inyecte
	@Autowired @Qualifier("log") private Logger log;
	@Autowired @Qualifier("logError") private Logger logError;
	
	/*Tambien se puede inyectar en el constructor
	@Autowired (no es necesaria ya)
	public ServicioPeliculas(@Autowired (no es necesaria ya) PeliculaDao peliculaDao) {
		super();
		this.peliculaDao = peliculaDao;
	}
	*/
	
	public ServicioPeliculas() {
		super();
		System.out.println("Creando un ServicioPeliculas");
	}

	/*@Autowired puede ir en la propiedad (set)
	//Si utilizamos el atributo para la inyección no necesitamos el set para nada
	/////Si la configurtación es XML si es necesario para poder escribir '<property name="peliculaDao" ref="peliculaDao"/>
	public void setPeliculaDao(PeliculaDao peliculaDao) {
		this.peliculaDao = peliculaDao;
	}
	*/

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


