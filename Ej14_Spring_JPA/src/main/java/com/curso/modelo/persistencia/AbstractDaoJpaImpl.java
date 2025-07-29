package com.curso.modelo.persistencia;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractDaoJpaImpl<T, k> implements InterfaceDao<T, k>{

	//@Autowired
	@PersistenceContext(name = "bbdd1")
	protected EntityManager em;
	
	@SuppressWarnings("unchecked")
	private Class<T> tipo = (Class<T>) ((ParameterizedType) getClass()
			.getGenericSuperclass())
			.getActualTypeArguments()[0];
	
	@Override
	public void insertar(T obj) {
		em.persist(obj);
	}
	
	@Override
	public void modificar(T obj) {
		em.merge(obj);
	}
	
	@Override
	public void borrar(T obj) {
		obj = em.merge(obj);
		em.remove(obj);
	}		
	
	@Override
	public T buscar(k id) {
		return (T) em.find(tipo, id);
	}
	
	@Override
	public List<T> listar() {
		//JPQL
		return em.createQuery("select o from "+tipo.getName()+" o").getResultList();
	}	
	
}






