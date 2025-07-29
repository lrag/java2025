package com.curso.modelo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.negocio.aop.LogAdvice;

//@Service("servicioClientesTarget")
@Service("servicioClientes")
public class ServicioClientesImpl implements ServicioClientes {
	
	//@Autowired
	//private ClienteDao clienteDao;
	
	@Override
	public void insertar(Cliente cliente){
		
		System.out.println("Insertando en GestorClientesImpl:"+cliente);
	
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void borrar(Cliente cliente){

		System.out.println("Borrando en GestorClientesImpl:"+cliente);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	
}

/*
@Service("gestorClientes")
class GestorClientesPROXY implements ServicioClientes {

	@Autowired
	private ServicioClientesImpl target;
	@Autowired
	private LogAdvice logAdvice;
	
	@Override
	public void insertar(Cliente cliente){
	
		try {
			logAdvice.before(null, null, cliente);
			target.insertar(cliente);
			logAdvice.afterReturning(cliente, null, null, cliente);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void borrar(Cliente cliente){

		target.borrar(cliente);

	}
	
}
*/

