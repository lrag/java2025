package com.curso.modelo.persistencia;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.curso.modelo.entidad.Cliente;

public abstract class AbstractJPADao<T, K> {

	@PersistenceContext
	protected EntityManager em;

	@SuppressWarnings("unchecked")
	private Class<T> tipo = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
			.getActualTypeArguments()[0];

	public void insertar(T obj) {
		em.persist(obj);
	}

	public void modificar(T obj) {
		em.merge(obj);
		//Hacemos flush para que se vean los updates aunque vayamos a hacer rollback
		em.flush();
	}

	public void borrar(T obj) {
		obj = em.merge(obj);
		em.remove(obj);
	}

	public T buscar(K id) {
		return (T) em.find(tipo, id);
	}

	public List<T> listar() {
		TypedQuery<T> q = em.createQuery("select c from "+tipo.getName()+" c", tipo);
		return q.getResultList();
	}
		
}
