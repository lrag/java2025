package com.curso.modelo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.modelo.entidad.bbdd2.Producto;
import com.curso.modelo.persistencia.bbdd2.ProductoRepositorio;

@Service
public class GestorProductos {

	@Autowired
	private ProductoRepositorio productoRepo;

	@Transactional(value = "bbdd2JpaTransactionManager")
	public void insertar(Producto producto){
		productoRepo.save(producto);
	}
	
}
