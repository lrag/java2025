package com.curso.modelo.persistencia;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractJPADao<E, k> {

	@PersistenceContext(unitName = "H2PU") //Si solo tenemos una unidad de persistencia no es necesario indicar el nombre
	protected EntityManager em;
	
	@SuppressWarnings("unchecked")
	private Class<E> tipo = (Class<E>) ((ParameterizedType) getClass()
			.getGenericSuperclass())
			.getActualTypeArguments()[0];	
		
	public void insertar(E entidad) {
		em.persist(entidad);
	}
	
	public void modificar(E entidad) {
		em.merge(entidad);
	}	
	
	public void borrar(k id) {
		E e = em.find(tipo, id);
		em.remove(e);
	}

	public E buscar(k id) {
		return em.find(tipo, id);
	}
	
	public List<E> listar() {
		return em.createQuery("select c from "+tipo.getName()+" c").getResultList();
	}		
	
}
