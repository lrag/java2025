package com.curso.modelo.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.curso.modelo.entidad.Persona;

//Esta anotación es completamente opcional
@Repository
public interface PersonaRepositorio extends JpaRepository<Persona, Integer>{

	
	List<Persona> findByDireccion(String direccion);
	
	List<Persona> findByDireccionOrTelefono(String direccion, String telefono);

	//JPQL 
	//@Query("select p from Persona where p.direccion=:direccion")
	@Query("select p from Persona p where p.direccion=?1")
	List<Persona> findByMovida(String direccion);
	
	//@Transactional
	//Esto deberíamos reservarlo para operaciones a granel (bulk)
	@Modifying
	@Query("update Persona p set p.nombre='PRUEBA'")
	void modificar();	
	
	/*
    //Distinct
	List<Persona> findDistinctPeopleByLastnameOrFirstname(String lastname, String firstname);
	List<Persona> findPeopleDistinctByLastnameOrFirstname(String lastname, String firstname);
	
	//Ignore case
	List<Persona> findByLastnameIgnoreCase(String lastname);
	List<Persona> findByLastnameAndFirstnameAllIgnoreCase(String lastname, String firstname);
	
	//Order by
	List<Persona> findByLastnameOrderByFirstnameAsc(String lastname);
	List<Persona> findByLastnameOrderByFirstnameDesc(String lastname);	
	
	//Relaciones
	List<Persona> findByDireccion_CodigoPostal(String codigoPostal);
	*/

}
