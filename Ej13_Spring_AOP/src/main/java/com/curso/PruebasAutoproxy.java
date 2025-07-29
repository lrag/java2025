package com.curso;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.entidad.Empleado;
import com.curso.modelo.negocio.ServicioClientes;
import com.curso.modelo.negocio.ServicioEmpleados;

public class PruebasAutoproxy {

	public static void main(String[] args) {
		
		//AbstractApplicationContext appCtx = new AnnotationConfigApplicationContext(Configuracion.class);
		AbstractApplicationContext appCtx = new ClassPathXmlApplicationContext("Beans_AutoProxy.xml");
		
		ServicioClientes gc = appCtx.getBean("servicioClientes", ServicioClientes.class);
		ServicioEmpleados ge = appCtx.getBean(ServicioEmpleados.class);
		
		Cliente c = new Cliente("Grace Hopper");
		gc.insertar(c);
		gc.borrar(c);
		
		Empleado e = new Empleado("Terence Hill");
		ge.insertar(e);
		ge.borrar(e);
						
		appCtx.close();
	}
	
}
