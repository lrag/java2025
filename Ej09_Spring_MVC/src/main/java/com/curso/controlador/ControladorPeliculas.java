package com.curso.controlador;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.curso.cfg.Configuracion;
import com.curso.modelo.entidad.Pelicula;
import com.curso.modelo.negocio.ServicioPeliculas;


/*
Los controladores de SpringMVC tienen su própio estereotipo
Nos basta con el ámbito singleton (no es obligatorio que lo sean)
	Es una particularidad especial de SpringMVC
	Hay que tener cuidado de que sean thread-safe 
Los controladores no se inyectan en ningún sitio
Reciben las llamadas desde el DispatcherServlet	

<bean id="controladorPeliculas" class="com.curso.controlador.ControladorPeliculas" scope="singleton" lazyInit=false">
	<contructor-arg ref="servicioPeliculas"/>
</bean>
*/
@Controller
public class ControladorPeliculas {

    private final Configuracion configuracion;

	private ServicioPeliculas servicioPeliculas;

	//Inyección en el constructor
	public ControladorPeliculas(ServicioPeliculas servicioPeliculas, Configuracion configuracion) {
		super();
		this.servicioPeliculas = servicioPeliculas;
		this.configuracion = configuracion;
	}

	/*
	@RequestMapping(
			method = RequestMethod.GET,
			path = "/listadoPeliculas"
		)
	*/
	@GetMapping(path = "/listadoPeliculas")
	public ModelAndView verListadoPeliculas() {
		System.out.println("ControladorPeliculas.verListadoPeliculas");
		//Escoger la siguiente vista
		//Preparar los datos para la vista
		ModelAndView mav = new ModelAndView("listadoPeliculas");
		List<Pelicula> peliculas = servicioPeliculas.listarPeliculas();
		mav.addObject("peliculas", peliculas);
		return mav;
	}

	/*
	Cuando la vista no necesita datos basta con devolver un modelAndView al que
	solo se le ha indicado el nombre de la vista
	public ModelAndView verFormularioPeliculas() {
		//ModelAndView tiene 'fluent api' 
		return new ModelAndView("formularioPeliculas");			
	}
	*/
	
	//Si no tenemos datos que añadir al M&V nos basta con devolver un String con el nombre de la vista
	@GetMapping(path = "/formularioPeliculas")
	public String verFormularioPeliculas() {
		System.out.println("ControladorPeliculas.verFormularioPeliculas");
		return "formularioPeliculas";			
	}	

	@PostMapping("/insertarPelicula")
	/*
	En los métodos de un @Controller pueden recibir parámetros
	Algunos de ellos no necesitan indicaciones para que SpringMVC sepa a qué nos estamos refiriendo:
		- HttpServletRequest
		- HttpServletResponse
		- HttpSession
		- ServletContext
	*/
	public void insertarPelicula_1(HttpServletRequest request, HttpSession sesion, HttpServletRequest otraVezElRequest) {
		System.out.println("ControladorPeliculas.insertarPelicula");
		
		String titulo = request.getParameter("titulo");
		String director = request.getParameter("director");
		String genero = request.getParameter("genero");
		String fecha = request.getParameter("fecha");
		
		Pelicula p = new Pelicula(null, titulo, director, genero, fecha);
		servicioPeliculas.insertarPelicula(p);
		//...		
	}
	
	@PostMapping("/insertarPelicula")
	public void insertarPelicula_2(HttpServletRequest request, HttpSession sesion, HttpServletRequest otraVezElRequest) {
		System.out.println("ControladorPeliculas.insertarPelicula");
		
		String titulo = request.getParameter("titulo");
		String director = request.getParameter("director");
		String genero = request.getParameter("genero");
		String fecha = request.getParameter("fecha");
		
		Pelicula p = new Pelicula(null, titulo, director, genero, fecha);
		servicioPeliculas.insertarPelicula(p);
		//...		
	}
	
	
	
	
}

