package com.curso.modelo.negocio;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.curso.modelo.entidad.Cliente;

@Service
public class ServicioClientes {

	//private ClienteDao clienteDao;
	
	/*
	public ServicioClientes(ClienteDao clienteDao) {
		super();
		this.clienteDao = clienteDao;
	}
	*/

	@Transactional
	public void insertar(Cliente cliente) {
		//LN...
		//clienteDao.insertar(cliente);
	}
	
	public List<Cliente> listar(){
		return null; //clienteDao.listar();
	}	

	public Cliente buscar(Integer id){
		return null; //clienteDao.buscar(id);
	}	
	
}
