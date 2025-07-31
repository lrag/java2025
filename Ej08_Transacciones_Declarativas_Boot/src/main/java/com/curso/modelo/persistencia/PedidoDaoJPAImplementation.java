package com.curso.modelo.persistencia;

import org.springframework.stereotype.Repository;
import com.curso.modelo.entidad.Pedido;

@Repository
public class PedidoDaoJPAImplementation extends AbstractJPADao<Pedido, Integer> implements PedidoDao {
}

