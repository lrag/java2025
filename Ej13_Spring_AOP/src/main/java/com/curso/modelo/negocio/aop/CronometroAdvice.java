package com.curso.modelo.negocio.aop;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

import com.curso.util.Logger;

@Component
public class CronometroAdvice implements MethodInterceptor {
	
	private Logger loggerCronometro;
	
	public CronometroAdvice(Logger loggerCronometro) {
		super();
		this.loggerCronometro = loggerCronometro;
	}

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		invocation.getArguments();                  //Los parámetros de la llamada
		Method metodo = invocation.getMethod();     //El método que se está invocando
		Object target = invocation.getStaticPart(); //El target
		
		//ANTES
		long inicio = System.currentTimeMillis();
		
		//Decidimos si invocamos al target o no
		Object retorno = invocation.proceed();
		
		//DESPUES
		long fin = System.currentTimeMillis();

		loggerCronometro.escribir(LocalDateTime.now()+": Llamada al metodo "+metodo.getName()+" de "+target.getClass()+" procesada en "+(fin-inicio)+" milisegundos.");
		System.out.println(LocalDateTime.now()+": Llamada al metodo "+metodo.getName()+" de "+target.getClass()+" procesada en "+(fin-inicio)+" milisegundos. ");
		
		return retorno;
	}
	
}


/*
 * COMO PODRÍAMOS CONVERTIR EN THREAD SAFE UN ADVCE CON MethodBeforeAdvice, AfterReturningAdvice
 * 
@Component
public class CronometroAdvice implements MethodBeforeAdvice, AfterReturningAdvice {

	Map<String, Long> tiemposInicio = new ConcurrentHashMap<>();

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		long inicio = System.currentTimeMillis();	
		tiemposInicio.put(Thread.currentThread().getName(), inicio);
	}

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		long fin = System.currentTimeMillis();
		String threadName = Thread.currentThread().getName();
		System.out.println(fin-tiemposInicio.get(threadName));
		tiemposInicio.remove(threadName);
	}
	
}
*/
