package com.curso.modelo.negocio;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.curso.modelo.entidad.Empleado;

@Service
public class ServicioEmpleados {
	
	//@Autowired
	//private EmpleadoDao empleadoDao;

	public void insertar(Empleado empleado){
		
		System.out.println("Insertando el empleado "+empleado+" en el GESTOR");
		//LN
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
				
	}
	

	@Async
	public void borrar(Empleado empleado){
		System.out.println("Borrando el empleado "+empleado+" en el GESTOR");
		//LN
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
	
	
	
}
