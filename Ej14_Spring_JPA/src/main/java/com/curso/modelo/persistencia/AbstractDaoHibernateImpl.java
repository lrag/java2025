package com.curso.modelo.persistencia;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDaoHibernateImpl<T, k> implements InterfaceDao<T, k>{

	@Autowired
	protected SessionFactory sf;
	
	@SuppressWarnings("unchecked")
	private Class<T> tipo = (Class<T>) ((ParameterizedType) getClass()
			.getGenericSuperclass())
			.getActualTypeArguments()[0];
	
	@Override
	public void insertar(T obj) {
		sf.getCurrentSession().persist(obj);
	}
	
	@Override
	public void modificar(T obj) {
		sf.getCurrentSession().merge(obj);
	}
	
	@Override
	public void borrar(T obj) {
		Session s = sf.getCurrentSession();
		obj = (T) s.merge(obj);
		s.remove(obj);
	}		
	
	@Override
	public T buscar(k id) {
		return (T) sf.getCurrentSession().find(tipo, id);
	}
	
	@Override
	public List<T> listar() {
		//HQL
		return sf.getCurrentSession().createQuery("select o from "+tipo.getName()+" o").getResultList();
	}	
	
}






