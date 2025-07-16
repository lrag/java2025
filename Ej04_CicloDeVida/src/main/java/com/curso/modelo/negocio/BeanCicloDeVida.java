package com.curso.modelo.negocio;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeanCicloDeVida implements InitializingBean, DisposableBean {

	private String dato;
	
	public BeanCicloDeVida() {
		super();
		System.out.println("Instanciando BeanCicloDeVida");
		System.out.println("Dato:"+dato);
	}

	public void setDato(String dato) {
		System.out.println("BeanCicloDeVida.setDato");
		this.dato = dato;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("BeanCicloDeVida.afterPropertiesSet");		
		System.out.println("Dato:"+dato);
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("BeanCicloDeVida.destroy");
	}
	
	//Si no queremos usar las interfaces podemos crear los metodos e indicarlo en 
	//la configuración
	//<bean id="logger" 
	//      class="com.curso.util.Logger"
	//      init-method="inicializar"
	//      destroy-method="destruir">
	//	<property name="nombreFichero" value="log.txt"/>
	//</bean>	
	public void inicializar() throws Exception {
	}
	
	public void finalizar() throws Exception {
		System.out.println("BeanCicloDeVida.finalizar");
	}	

	//Tambien se le puede pedir a Spring que busque las anotaciones
	//JEE para el ciclo de vida	
	@PostConstruct
	public void inicializar2() throws Exception{
		System.out.println("BeanCicloDeVida.inicializar2");
	}
	
	@PreDestroy
	public void destruir2() throws Exception{
		System.out.println("BeanCicloDeVida.finalizar2");
	}
	
}
