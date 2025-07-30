package com.curso.controlador;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.curso.modelo.entidad.Pelicula;
import com.curso.modelo.negocio.ServicioGeneros;
import com.curso.modelo.negocio.ServicioPeliculas;

@Controller
public class ControladorPeliculas {

	private ServicioPeliculas servicioPeliculas;
	private ServicioGeneros   servicioGeneros;
	
	public ControladorPeliculas(ServicioPeliculas servicioPeliculas, ServicioGeneros servicioGeneros) {
		super();
		this.servicioPeliculas = servicioPeliculas;
		this.servicioGeneros = servicioGeneros;
	}

	@GetMapping(path = "/listadoPeliculas")
	public ModelAndView verListadoPeliculas() {
		System.out.println("ControladorPeliculas.verListadoPeliculas");
		ModelAndView mav = new ModelAndView("listadoPeliculas");
		List<Pelicula> peliculas = servicioPeliculas.listarPeliculas();
		mav.addObject("peliculas", peliculas);
		return mav;
	}

	@GetMapping(path = "/formularioPeliculas")
	public ModelAndView verFormularioPeliculas() {
		return new ModelAndView("formularioPeliculas")
			.addObject("pelicula", new Pelicula())
			.addObject("generos", servicioGeneros.listarGeneros());			
	}

	@GetMapping(path = "/seleccionarPelicula/{id}")
	public ModelAndView seleccionarPelicula(@PathVariable("id") Integer idPelicula) { 
		Pelicula pSel = servicioPeliculas.buscarPelicula(idPelicula);
		return new ModelAndView("formularioPeliculas")
			.addObject("pelicula", pSel)
			.addObject("generos", servicioGeneros.listarGeneros());			
	}

	//Tambien podemos escribir el método así
	@PostMapping("/insertarPelicula")
	public String insertarPelicula(@ModelAttribute("pelicula") Pelicula pelicula) {
		servicioPeliculas.insertarPelicula(pelicula);
		return "redirect:listadoPeliculas";
	}		
	
}

