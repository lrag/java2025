package com.curso.modelo.persistencia;

import java.util.List;

import com.curso.modelo.entidad.Cliente;

public interface InterfaceDao<E, k> {

	void insertar(E entity);
	void modificar(E entity);
	void borrar(k id);
	E buscar(k id);
	List<E> listar();

}