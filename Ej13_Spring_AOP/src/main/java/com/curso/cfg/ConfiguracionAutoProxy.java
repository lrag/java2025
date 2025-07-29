package com.curso.cfg;

import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.curso.modelo.negocio.aop.CronometroAdvice;
import com.curso.modelo.negocio.aop.LogAdvice;
import com.curso.util.Logger;

@Configuration
@ComponentScan({"com.curso.modelo.negocio", "com.curso.modelo.negocio.aop", "com.curso.util"})
public class ConfiguracionAutoProxy {
	
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
	
	//ADVICE: Sabe QUÉ hay que hacer. No sabe ni cuándo hay que hacelo ni quién es el target.
	//Estas clases guardan el código del cual hemos sacado factor común 
	//LogAdvice y CronometroAdvice están registrados como @Component
	
	//POINTCUT: Sabe cuándo, no sabe qué y no sabe quién
	@Bean
	JdkRegexpMethodPointcut negocioPointcut(){
		JdkRegexpMethodPointcut pc = new JdkRegexpMethodPointcut();		
		//.*insertarCliente : El metodo 'insertarCliente' de cualquier clase y paquete
		//.*insertar.*      : Métodos cuyo nombre comience por 'insertar' de cualquier clase y paquete
		//com.curso.modelo.negocio.GestorClientes.*(..) : Cualquier método de la clase GestorClientes
		//com.curso.modelo.negocio.*.*(..): Cualquier metodo de cualquier clase del paquete negocio
		pc.setPattern("com.curso.modelo.negocio.*.*(..)");
		return pc;
	}
	
	//ADVISOR: Junta el QUÉ con el CUÁNDO 
	@Bean
	DefaultPointcutAdvisor logAdvisor(LogAdvice logAdvice, Pointcut negocioPointcut) {
		DefaultPointcutAdvisor dpa = new DefaultPointcutAdvisor();
		dpa.setPointcut(negocioPointcut);
		dpa.setAdvice(logAdvice);
		return dpa;
	}		

	@Bean
	DefaultPointcutAdvisor cronometroAdvisor(CronometroAdvice cronometroAdvice, Pointcut negocioPointcut) {
		DefaultPointcutAdvisor dpa = new DefaultPointcutAdvisor();
		dpa.setPointcut(negocioPointcut);
		dpa.setAdvice(cronometroAdvice);
		return dpa;
	}		
	
	@Bean
	//Esta bean se encargará de cruzar los advisor con las beans para averiguar cuáles necesitan proxy	
	DefaultAdvisorAutoProxyCreator autoProxyCreator() {
		return new DefaultAdvisorAutoProxyCreator();
	}
	
}


