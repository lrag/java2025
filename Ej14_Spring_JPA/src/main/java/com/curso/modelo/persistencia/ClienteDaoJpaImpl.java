package com.curso.modelo.persistencia;

import org.springframework.stereotype.Repository;
import com.curso.modelo.entidad.Cliente;

@Repository
public class ClienteDaoJpaImpl extends AbstractDaoJpaImpl<Cliente, Integer> implements ClienteDao {
	//Si clienteDao tuviera algún método extra se implementaría aquí
}
