package com.curso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.modelo.entidad.Persona;
import com.curso.modelo.negocio.GestorPersonas;
import com.curso.modelo.persistencia.PersonaRepositorio;

@SpringBootApplication
public class Aplicacion implements CommandLineRunner{

	@Autowired private GestorPersonas gestorPersonas;
	@Autowired private PersonaRepositorio personaRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(Aplicacion.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		personaRepo.save(new Persona(null,"Ringo Starr","C/Tal","555123"));
		
		Persona p = new Persona(195, "Groucho Marx", "C/Tal", "555123");
		personaRepo.save(p);

		System.out.println("========================================");
		List<Persona> personas = personaRepo.findAll();
		for(Persona pAux: personas){
			System.out.println(pAux);
		}
		
	}

}
