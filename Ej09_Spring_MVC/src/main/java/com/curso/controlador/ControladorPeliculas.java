package com.curso.controlador;

import org.springframework.stereotype.Controller;

import com.curso.modelo.negocio.ServicioPeliculas;


/*
Los controladores de SpringMVC tienen su própio estereotipo
Nos basta con el ámbito singleton (no es obligatorio que lo sean)
	Es una particularidad especial de SpringMVC
	Hay que tener cuidado de que sean thread-safe 
*/
@Controller
public class ControladorPeliculas {

	private ServicioPeliculas servicioPeliculas;

	public ControladorPeliculas(ServicioPeliculas servicioPeliculas) {
		super();
		this.servicioPeliculas = servicioPeliculas;
	}

	public void verListadoPeliculas() {
		
		
		
	}
	
	
}
