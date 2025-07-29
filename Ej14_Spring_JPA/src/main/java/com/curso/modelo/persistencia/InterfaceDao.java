package com.curso.modelo.persistencia;

import java.util.List;

import com.curso.modelo.entidad.Cliente;

public interface InterfaceDao<T, k> {

	//Aqui definimos los métodos comunes a todos los dao
	void insertar(T entidad);
	void modificar(T entidad);
	void borrar(T entidad);
	T buscar(k id);
	List<T> listar();
	
}
