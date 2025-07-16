package com.curso.persistencia;

import java.util.List;

public interface InterfaceDao<T, k> {

	void insertar(T entidad);
	void modificar(T entidad);
	void borrar(T entidad);
	T buscar(k id);
	List<T> listar();
	
}
