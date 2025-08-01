package com.curso.modelo.negocio;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.persistencia.RepositorioClientes;

@Service
@Transactional
public class ServicioClientes {

	private RepositorioClientes repoClientes;
	
	public ServicioClientes(RepositorioClientes repoClientes) {
		super();
		this.repoClientes = repoClientes;
	}

	public void insertarCliente(Cliente cliente) {
		//
		//LN para insertar
		//
		repoClientes.save(cliente);
	}
	
	public void modificarCliente(Cliente cliente) {
		//
		//LN para modificar
		//
		repoClientes.save(cliente);
	}
	
	public void borrarCliente(Cliente cliente) {
		//
		//LN para eliminar
		//
		repoClientes.delete(cliente);
	}
		
}





