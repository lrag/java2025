package com.curso.modelo.negocio;

import org.springframework.stereotype.Service;

import com.curso.modelo.negocio.excepcion.DatosBancariosException;

@Service
public class GestorBancos {

	public void comprobarTC(Integer numeroTC) throws DatosBancariosException {
		
		System.out.print("comprobando TC...");
		
		if(numeroTC<5000) {
			System.out.println("MAL");
			
			//TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			
			throw new DatosBancariosException("Datos bancarios incorrectos");
		}
		
		System.out.println("OK");
	}	
	
	
	
}
















