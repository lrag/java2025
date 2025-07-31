package com.curso.modelo.negocio;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.curso.modelo.negocio.excepcion.PerritoPilotoException;

@Service
public class ServicioOfertas {

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class )
	public String obtenerPerritoPiloto(boolean hayPerritoPiloto) throws PerritoPilotoException {

		System.out.print("Obteniendo perrito piloto...");

		if (!hayPerritoPiloto) {
			System.out.println("MAL");

			//TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			throw new PerritoPilotoException("No hay perrito piloto");
		}
		System.out.println("OK");
		System.out.println("TX chunga (perrito piloto):"+TransactionAspectSupport.currentTransactionStatus().isRollbackOnly());
		
		return "Perrito piloto";

	}

}
