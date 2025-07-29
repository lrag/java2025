package com.curso.cfg;

import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.curso.modelo.negocio.ServicioClientes;
import com.curso.modelo.negocio.ServicioClientesImpl;
import com.curso.modelo.negocio.aop.CronometroAdvice;
import com.curso.modelo.negocio.aop.LogAdvice;
import com.curso.util.Logger;

@Configuration
@ComponentScan({"com.curso.modelo.negocio", "com.curso.modelo.negocio.aop", "com.curso.util"})
public class Configuracion {
	
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
	
	//POINTCUT: Sabe cuándo, no sabe qué y no sabe quién es el target
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

	//Proxy
	//No damos de alta el proxy. Damos de alta al objeto que programará el proxy y luego lo registrará en el contenedor de esprín
	@Bean
	//Al proxy le asignamos el id 'bonito'
	ProxyFactoryBean gestorClientes(/*@Autowired*/ /*GestorClientes gestorClientes*/) throws ClassNotFoundException {
		
		//La tarea de este objeto es la de programar el proxy y registrarlo en el contenedor de Spring
		ProxyFactoryBean pfb = new ProxyFactoryBean();
		
		//Qué interfaces debe implementar el proxy
		@SuppressWarnings("rawtypes")
		Class[] arrayInterfaces = { ServicioClientes.class };		
		pfb.setProxyInterfaces(arrayInterfaces);
		
		//Quién es el target
		//Habría que satisfacer las dependencias de GestorClientes 
		//Esto es una inner bean
		ServicioClientes gc = new ServicioClientesImpl();
		pfb.setTarget(gc);
		
		//Qué advisors hay que tener en cuenta
		pfb.setInterceptorNames("cronometroAdvisor", "logAdvisor");
		
		return pfb;
	}	
		
}


/*
class ServicioClientes_PROXY implements GestorClientes {

	private GestorClientesImpl target;
	
	private LogAdvice logAdvice;
	
	public void setTarget(GestorClientesImpl target) {
		this.target = target;
	}

	@Override
	public void insertar(Cliente cliente) {
		logAdvice.before(null, null, cliente);
		target.insertar(cliente);
		logAdvice.afterReturning(cliente, null, null, cliente);
	}

	@Override
	public void borrar(Cliente cliente) {
		logAdvice.before(null, null, cliente);
		target.borrar(cliente);
		logAdvice.afterReturning(cliente, null, null, cliente);
	}
	
}
*/









