package com.curso.modelo.negocio;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.persistencia.ClienteDao;
import com.curso.modelo.persistencia.InterfaceDao;

@Service
public class ServicioClientes {

	private InterfaceDao<Cliente, Integer> clienteDao;
	
	public ServicioClientes(ClienteDao clienteDao) {
		super();
		this.clienteDao = clienteDao;
	}

	@Transactional
	public void insertar(Cliente cliente) {
		//LN...
		clienteDao.insertar(cliente);
	}
	
	public List<Cliente> listar(){
		return clienteDao.listar();
	}	

	public Cliente buscar(Integer id){
		return clienteDao.buscar(id);
	}	
	
}
