package com.curso.modelo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.modelo.entidad.Persona;
import com.curso.modelo.persistencia.PersonaRepositorio;

@Service
public class GestorPersonas {

	@Autowired
	private PersonaRepositorio personaRepo;

	@Transactional
	public void modificarNombre(Integer id, String nombre){
		Persona pAux = personaRepo.findById(id).get();
		pAux.setNombre(nombre);
	}

	@Transactional
	public void modificarPersonas(){
		personaRepo.modificar();
	}
	
}
