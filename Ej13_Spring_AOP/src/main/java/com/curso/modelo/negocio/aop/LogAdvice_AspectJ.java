package com.curso.modelo.negocio.aop;

import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAdvice_AspectJ{
	
	@Before("within(com.curso.modelo.negocio.*)")	
	public void before(JoinPoint jp) throws Throwable {
		jp.getTarget();
		jp.getArgs();
		jp.getSignature().getName();
		System.out.println("Llamada al método "+jp.getSignature().getName()+". "+LocalDateTime.now());		
	}

	@AfterReturning("within(com.curso.modelo.negocio.*)")	
	public void afterReturning(JoinPoint jp) throws Throwable {
		System.out.println("Fin de la llamada al método "+jp.getSignature().getName()+". "+LocalDateTime.now());
	}

}
