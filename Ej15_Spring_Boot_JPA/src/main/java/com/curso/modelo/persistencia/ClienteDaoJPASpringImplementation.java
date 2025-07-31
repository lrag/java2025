package com.curso.modelo.persistencia;

import org.springframework.stereotype.Repository;
import com.curso.modelo.entidad.Cliente;

@Repository
public class ClienteDaoJPASpringImplementation extends AbstractJPADao<Cliente, Integer> implements ClienteDao {
	//Aquí iria la implementación de los métodos específicos de ClienteDao
}




