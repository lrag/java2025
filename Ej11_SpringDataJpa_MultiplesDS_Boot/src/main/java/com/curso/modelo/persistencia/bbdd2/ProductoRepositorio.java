package com.curso.modelo.persistencia.bbdd2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.modelo.entidad.bbdd2.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer>{
	
}
