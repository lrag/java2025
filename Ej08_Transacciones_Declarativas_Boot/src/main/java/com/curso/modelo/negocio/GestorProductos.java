package com.curso.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.curso.modelo.entidad.Producto;
import com.curso.modelo.persistencia.ProductoDao;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class GestorProductos {

	@Autowired
	private ProductoDao productoDao;
	
	@Transactional()
	public void insertar(Producto obj) {
		//LN
		productoDao.insertar(obj);
	}

	public void modificar(Producto obj) {
		//LN
	}

	public void borrar(Producto obj) {
		//LN
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public Producto buscar(Integer id) {
		return null;
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public List<Producto> listar() {
		return productoDao.listar();
	}

}
