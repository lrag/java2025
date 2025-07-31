package com.curso.modelo.negocio;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.curso.modelo.entidad.Pelicula;
import com.curso.modelo.persistencia.PeliculaDao;

@Service("gestorPeliculas")
public class GestorPeliculas /*implements ApplicationContextAware, InitializingBean*/ {

	/*Hasta Spring 4.2
	private ApplicationContext applicationContext;
	private GestorPeliculas proxy;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		proxy = applicationContext.getBean(GestorPeliculas.class);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	*/			
	
	
	@Autowired private PeliculaDao peliculaDao;
	
	//Desde Spring 4.3:
	@Autowired private GestorPeliculas proxy;

	@Transactional(
			propagation = Propagation.REQUIRES_NEW
		)
	public void insertar(Pelicula pelicula) throws Exception {

		System.out.print("Comprobando titulo...");
		if (pelicula.getTitulo() == null) {
			System.out.println("MAL");
			// Podemos indicar explícitamente que queremos rollback al final:
			// TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			// Si queremos detener el proceso lo suyo es lanzar una excepcion
			throw new Exception("Titulo nulo");
		}

		System.out.println("OK");
		peliculaDao.insertar(pelicula);

	}

	//@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void insertar(List<Pelicula> peliculas) throws Exception {
		for (Pelicula p : peliculas) {
			this.insertar(p);
			//proxy.insertar(p); 
		}
		//OTRO INSERT
	}

	@Transactional
	public void borrar(Pelicula pelicula) {
		peliculaDao.borrar(pelicula);
	}

	public List<Pelicula> listarTodas() {
		return peliculaDao.listar();
	}

	public void borrarPeliculas() {
		peliculaDao.borrarPeliculas();		
	}

}
