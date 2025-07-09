package com.curso.persistencia;

import java.util.List;

public interface InterfaceDao<T, k> {

	void insertar(T pelicula);
	void modificar(T pelicula);
	void borrar(T pelicula);
	T buscar(k id);
	List<T> listar();
	
}
