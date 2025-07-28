package com.curso.controlador;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
//@Controller
public class ControladorPeliculas_Comentarios {

	private ServicioPeliculas servicioPeliculas;

	//Inyección en el constructor
	public ControladorPeliculas_Comentarios(ServicioPeliculas servicioPeliculas) {
		super();
		this.servicioPeliculas = servicioPeliculas;
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

	@GetMapping(path = "/formularioPeliculas")
	public ModelAndView verFormularioPeliculas() {
		//ModelAndView tiene 'fluent api' 
		return new ModelAndView("formularioPeliculas")
			.addObject("pelicula", new Pelicula());			
	}
	
	/*
	GET /seleccionarPelicula/5
	GET /seleccionarPelicula/15
	GET /seleccionarPelicula/33
	*/
	@GetMapping(path = "/seleccionarPelicula/{id}")
	public ModelAndView seleccionarPelicula(@PathVariable("id") Integer idPelicula) { //Si pel parámetro del método se llamara 'id' bastaría con '@PathVariable Integer id'
		Pelicula pSel = servicioPeliculas.buscarPelicula(idPelicula);
		return new ModelAndView("formularioPeliculas")
			.addObject("pelicula", pSel);		
	}
	
	//Si no tenemos datos que añadir al M&V nos basta con devolver un String con el nombre de la vista
	/*
	@GetMapping(path = "/formularioPeliculas")
	public String verFormularioPeliculas() {
		System.out.println("ControladorPeliculas.verFormularioPeliculas");
		return "formularioPeliculas";			
	}
	*/	

	/*
	En los métodos de un @Controller pueden recibir parámetros
	Algunos de ellos no necesitan indicaciones para que SpringMVC sepa a qué nos estamos refiriendo:
		- HttpServletRequest
		- HttpServletResponse
		- HttpSession
		- ServletContext
	*/
	//@PostMapping("/insertarPelicula")
	public void insertarPelicula_1(HttpServletRequest request, HttpSession sesion, HttpServletRequest otraVezElRequest) {
		System.out.println("ControladorPeliculas.insertarPelicula");
		
		//Cuando pides un parámetro te lo dan como String
		//y hay que transformarlo a lo que sea manualmente
		//Por ejemplo a int, long, double, boolean
		String titulo = request.getParameter("titulo");
		String director = request.getParameter("director");
		String genero = request.getParameter("genero");
		String yearStr = request.getParameter("year"); //Esto hay que transformarlo en una fecha
		int year = Integer.parseInt(yearStr);
		
		Pelicula p = new Pelicula(null, titulo, director, genero, year);
		servicioPeliculas.insertarPelicula(p);
		//...		
	}
	
	//Podemos solicitar parámetros individuales de la petición
	//SpringMVC es capaz de hacer una conversión de String a
	//-int
	//-long
	//-double
	//-Wrappers equivalentes
	//-Fechas 
	//
	//Si utilizamos @RequestParam el parámetro será obligatorio
	//Si queremos que nos esntreguen un parámetro que no está siempre debemos indicarlo
	//@RequestParam(required = false)
	//
	//@PostMapping("/insertarPelicula")
	public void insertarPelicula_2(
			//Antes se debia indicar siempre el nombre del parámetro de la petición HTTP
			@RequestParam("titulo") String titulo,
			//Ahora, si el nombre del parámetro coincide con el nombre del parámetro del método 
			//nos lo podemos ahorrar
			@RequestParam String director,
			@RequestParam String genero,
			@RequestParam Integer year
		) {
		
		Pelicula p = new Pelicula(null, titulo, director, genero, year);
		servicioPeliculas.insertarPelicula(p);
		//...		
	}	
	
	//Pero en realidad lo que queremos es que SpringMVC contruya un objeto
	//con los parámetros
	//Para pedir un objeto hecho a partir de parámetros se utiliza @ModelAttribute
	//Es necesario que la clase del objeto que se va a crear sea una Java Bean
	
	//Este está mal!!!
	//Despues de un post no podemos devolver un contenido y debemos utilizar
	//el 'patrón' POST - REDIRECT - GET
	/*
	@PostMapping("/insertarPelicula")
	public ModelAndView insertarPelicula(@ModelAttribute("pelicula") Pelicula pelicula) {
		servicioPeliculas.insertarPelicula(pelicula);

		return new ModelAndView("listadoPeliculas")
			.addObject("peliculas", servicioPeliculas.listarPeliculas());
	}	
	*/
	
	//HACIENDO UN REDIRECT CON EL API DE SERVLETS (por el interés de la ciencia)
	//El redirect se le pide al objeto HttpServletResponse:
	//response.sendRedirect("vistas/listadoPeliculas.jsp")
	
	//Redirect con SpringMVC
	//@PostMapping("/insertarPelicula")
	public ModelAndView insertarPelicula_(@ModelAttribute("pelicula") Pelicula pelicula) {
		
		servicioPeliculas.insertarPelicula(pelicula);

		//Para hacer un redirect se utiliza la siguiente sintaxis en la vista que se le proporciona al M&V
		//Los redirect no se hacen a las vistas, se hacen al controlador
		//que mostrará la vista según el patrón MVC
		//return new ModelAndView("redirect:../vistas/listadoPeliculas.jsp");
		return new ModelAndView("redirect:listadoPeliculas");
	}	
	
	//Tambien podemos escribir el método así
	@PostMapping("/insertarPelicula")
	public String insertarPelicula(@ModelAttribute("pelicula") Pelicula pelicula) {
		servicioPeliculas.insertarPelicula(pelicula);
		return "redirect:listadoPeliculas";
	}		
	
}

