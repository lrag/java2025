package com.curso.modelo.persistencia.bbdd1;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.modelo.entidad.bbdd1.Persona;

public interface PersonaRepositorio extends JpaRepository<Persona, Integer>{

}
