package com.curso.modelo.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.entidad.Factura;

@Repository
public interface RepositorioFacturas extends JpaRepository<Factura, Integer>{
	List<Factura> findByCliente(Cliente cliente);
}
