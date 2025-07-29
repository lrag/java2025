package com.curso.modelo.negocio.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CronometroAdvice_AspectJ {

	//@Around("@target(org.springframework.stereotype.Service)")
	@Around("within(com.curso.modelo.negocio.*)")
	public Object intercept(ProceedingJoinPoint pjp) throws Throwable {
		
		long inicio = System.currentTimeMillis();
		
		Object retorno = pjp.proceed();
		
		long fin = System.currentTimeMillis();
		System.out.println("Llamada al metodo "+pjp.getSignature().getName()+" procesada en "+(fin-inicio)+" microsegundos.");
		
		return retorno;
		
	}

}
