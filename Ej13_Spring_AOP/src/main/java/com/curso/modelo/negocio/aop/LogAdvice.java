package com.curso.modelo.negocio.aop;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import com.curso.util.Logger;

//REgistramos definiciones de bean para los Advices
//Nos basta con que sean singleton
@Component
public class LogAdvice implements MethodBeforeAdvice, AfterReturningAdvice {
	
	private Logger logger;
	
	public LogAdvice(Logger logger) {
		super();
		this.logger = logger;
	}

	@Override
	public void before(Method method, Object[] parametros, Object target) throws Throwable {
		logger.escribir(LocalDateTime.now()+": Llamada al método "+method.getName()+" de "+target.getClass());
		System.out.println(LocalDateTime.now()+": Llamada al método "+method.getName()+" de "+target.getClass());
	}

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] parametros, Object target) throws Throwable {
		logger.escribir(LocalDateTime.now()+": Fin de la llamada al método "+method.getName()+" de "+target.getClass());
		System.out.println(LocalDateTime.now()+": Fin de la llamada al método "+method.getName()+" de "+target.getClass());
	}
	
}
