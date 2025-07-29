package com.curso.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.curso.util.Logger;

@Configuration
@ComponentScan({"com.curso.modelo.negocio", "com.curso.modelo.negocio.aop", "com.curso.util"})
@EnableAspectJAutoProxy
public class Configuracion_AspectJ {

	@Bean
	Logger logger() {
		Logger logger = new Logger();
		logger.setNombreFichero("logs/log.txt");
		return logger;
	}

	@Bean
	Logger loggerCronometro() {
		Logger logger = new Logger();
		logger.setNombreFichero("logs/logCronometro.txt");
		return logger;
	}	

}