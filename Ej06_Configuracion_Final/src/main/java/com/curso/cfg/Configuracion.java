package com.curso.cfg;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.curso.modelo.negocio.ServicioPeliculas;
import com.curso.persistencia.PeliculaDao;
import com.curso.util.Logger;


@Configuration
//@ComponentScan(basePackages= { "com.curso.modelo.negocio", "com.curso.persistencia"})
@ComponentScan(basePackages= { "com.curso"})
public class Configuracion {

	public Configuracion() {
		super();
		System.out.println("Creando configuracion.java");
	}

	@Bean
	@Scope("singleton")  //Por defecto es singleton
	@Lazy(value = false) //Por defecto tiene inicialización ansiosa
	DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		//Estos valores los sacaríamos de un fichero de configuración!
		ds.setUrl("jdbc:h2:C:/H2/bbdd_peliculas_2025");
		ds.setDriverClassName("org.h2.Driver");
		ds.setUsername("sa");
		ds.setPassword("");
		return ds;		
	}

	@Bean
	Logger log() {
		Logger log = new Logger();
		log.setNombreFichero("log.txt");
		return log;
	}

	@Bean
	Logger logError() {
		Logger logError = new Logger();
		logError.setNombreFichero("logError.txt");
		return logError;
	}	
	
}
