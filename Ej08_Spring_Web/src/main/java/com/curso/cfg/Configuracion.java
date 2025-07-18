package com.curso.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.curso.modelo.entidad.ClaseEjemplo;

@Configuration
//@ComponentScan(basePackages = { "com.curso.modelo.negocio" })
@ComponentScan(basePackages = "com.curso.modelo.negocio")
public class Configuracion {

	
	@Bean
	ClaseEjemplo objetoSingleton() {
		return new ClaseEjemplo();
	}
	
	@Bean
	@Scope("prototype")
	ClaseEjemplo objetoPrototype() {
		return new ClaseEjemplo();
	}
	
	@Bean
	@Scope("request")
	ClaseEjemplo objetoRequest() {
		return new ClaseEjemplo();
	}
	
	@Bean
	@Scope("session")
	ClaseEjemplo objetoSession() {
		return new ClaseEjemplo();
	}
	
}
