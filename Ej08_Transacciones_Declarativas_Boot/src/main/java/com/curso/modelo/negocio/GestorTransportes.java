package com.curso.modelo.negocio;

import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class GestorTransportes {
	
	public String obtenerCamion(boolean hayCamion) throws Exception{
		
		System.out.print("Reservando un camión...");
		if(!hayCamion) {
			System.out.println("MAL");
			
			//TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new Exception("No hay camión");
		}
		
		System.out.println("OK");
		return "MOOOOC MOOOOOOC!";
		
	}
	
}
