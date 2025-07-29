package com.curso;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.curso.cfg.Configuracion_AspectJ;
import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.entidad.Empleado;
import com.curso.modelo.negocio.ServicioClientes;
import com.curso.modelo.negocio.ServicioEmpleados;

public class Pruebas_AspectJ {

	public static void main(String[] args) {
		
		AbstractApplicationContext appCtx = new AnnotationConfigApplicationContext(Configuracion_AspectJ.class);
				
		ServicioClientes gc = appCtx.getBean("servicioClientes", ServicioClientes.class);
		ServicioEmpleados ge = appCtx.getBean(ServicioEmpleados.class);
		
		Cliente c = new Cliente("Grace Hopper");
		gc.insertar(c);
		gc.borrar(c);
		
		Empleado e = new Empleado("Terence Hill");
		ge.insertar(e);
		ge.borrar(e);
		
	}
	
}
