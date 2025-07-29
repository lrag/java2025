package com.curso.modelo.negocio;

import com.curso.modelo.entidad.Cliente;

public interface ServicioClientes {

	void insertar(Cliente cliente);
	void borrar(Cliente cliente);

}