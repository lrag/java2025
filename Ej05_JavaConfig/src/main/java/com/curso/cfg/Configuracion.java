package com.curso.cfg;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.curso.modelo.negocio.ServicioPeliculas;
import com.curso.persistencia.PeliculaDao;
import com.curso.util.Logger;

//Para refererenciar otra clase @Configuration
//@Import({ AppConfigOthers.class }) //loads another JavaConfig

//Para referenciar un xml
//@ImportResource("classpath:/config/spring-web-servlet.xml")

//Para indicar que hay clases con anotaciones:
//<context:component-scan basePackage="..."/>
//@ComponentScan(basePackages= { "com.curso.modelo.negocio", "com.curso.modelo.persistencia"})

//@Configuration no es obligatoria, pero si no lo colocamos perdemos algunas cosillas.
@Configuration
public class Configuracion {

	public Configuracion() {
		super();
		System.out.println("Creando configuracion.java");
	}

	/*
	<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<property name="url"             value="jdbc:h2:C:/H2/bbdd_peliculas_2025"/>
		<property name="driverClassName" value="org.h2.Driver"/>
		<property name="username"        value="sa"/>
		<property name="password"        value=""/>
	</bean>
	*/
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
	

	/*
	<bean id="peliculaDao" class="com.curso.modelo.persistencia.PeliculaDao">
		<property name="dataSource" ref="dataSource"/>
	</bean>	
	*/
		
	@Bean
	//Si necesitamos otras beans para inyectar las solicitamos como parámetro
	//Los autowired aqui son ya opcionales
	PeliculaDao peliculaDao(@Autowired DataSource dataSource) {
		PeliculaDao pDao = new PeliculaDao();
		pDao.setDataSource(dataSource);
		return pDao;
	}	
	
	
	/*
	<bean id="servicioPeliculas" class="com.curso.modelo.negocio.ServicioPeliculas">
		<property name="peliculaDao" ref="peliculaDao"/>
		<property name="log" ref="log"/>
		<property name="logError" ref="logError"/>
	</bean>	
	*/	
	@Bean
	ServicioPeliculas servicioPeliculas(
			PeliculaDao peliculaDao, 
			Logger log, 
			Logger logError
		) {
		ServicioPeliculas sp = new ServicioPeliculas();
		sp.setLog(log);
		sp.setLogError(logError);
		sp.setPeliculaDao(peliculaDao);
		return sp;
	}
	
	/*
	<bean id="log" class="com.curso.util.Logger">
		<property name="nombreFichero" value="log.txt"/>
	</bean>
	*/
	@Bean
	Logger log() {
		Logger log = new Logger();
		log.setNombreFichero("log.txt");
		return log;
	}
	
	/*
	<bean id="logError" class="com.curso.util.Logger">
		<property name="nombreFichero" value="logError.txt"/>
	</bean>
	*/	
	@Bean
	Logger logError() {
		Logger logError = new Logger();
		logError.setNombreFichero("logError.txt");
		return logError;
	}
	
	
}
