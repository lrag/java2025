package com.curso.modelo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.curso.modelo.entidad.Producto;
import com.curso.modelo.negocio.excepcion.ExistenciasException;
import com.curso.modelo.persistencia.ProductoDao;

@Service
@Transactional(propagation=Propagation.REQUIRED) 
public class GestorAlmacen {
	
	@Autowired ProductoDao productoDao;

	public void comprobarExistencias(Producto producto, Integer cantidad) throws ExistenciasException {
		
		System.out.printf("Comprobando existencias para el producto %s, cantidad %d...", 
				          producto.getNombre(), cantidad);
		
		producto = productoDao.buscar(producto.getId());		
		if(producto.getExistencias()<cantidad) {
			System.out.println("MAL");
			//TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new ExistenciasException(producto, cantidad, producto.getExistencias());
		}
		
		System.out.println("OK");
		
	}
	
	//Supongamos que este método también es invocado desde un controlador (por ejemplo desde Controladoralmacén)
	//Entonces necesita transacción por si mismo
	//@Transactional(propagation = Propagation.REQUIRED)
	@Transactional //Igual que la anterior
	public void reducirExistencias(Producto producto, Integer cantidad){
		System.out.println("Reduciendo existencias del producto "+producto.getNombre());
		
		producto = productoDao.buscar(producto.getId());		
		producto.setExistencias(producto.getExistencias()-cantidad);
		productoDao.modificar(producto);
	}	
	
}









