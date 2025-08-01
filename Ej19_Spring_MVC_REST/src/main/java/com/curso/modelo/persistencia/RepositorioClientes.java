package com.curso.modelo.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.modelo.entidad.Cliente;

@Repository
public interface RepositorioClientes extends JpaRepository<Cliente, Integer>{
	List<Cliente> findByDireccion(String direccion);
}
