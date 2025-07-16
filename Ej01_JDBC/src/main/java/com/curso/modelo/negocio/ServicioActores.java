package com.curso.modelo.negocio;

import com.curso.modelo.entidad.Actor;
import com.curso.persistencia.ActorDao;

public class ServicioActores {

	//SINGLETON//////////////////////////////////////////////////////////
	private static ServicioActores instancia;

	static {
		instancia = new ServicioActores();
	}
	
	public static ServicioActores getInstancia() {
		return instancia;
	}
	//SINGLETON//////////////////////////////////////////////////////////
	
	private ServicioActores() {
	}
	
	private ActorDao actorDao;
	private ServicioPeliculas servicioPeliculas = ServicioPeliculas.getInstancia();
	
	public void altaActor(Actor actor) {
		
		//Validar los datos...
		//Comprobar que el director existe...
		//...
		
		actorDao.insertar(actor);
		
		//...
		
	}
	
	
	public static void main(String[] args) {
		
		
		
		Erencio eren = new Erencio();
		eren.noHacerCaso();
		eren.metodoEstatico();
		
		Erencio.metodoEstatico();
		
		
		
		
		
		
	}
	
	
}


class Erencio {
	
	public static void metodoEstatico() {
		
	}
	
	public void noHacerCaso() {
		
	}
	
	public void desencadenarElRetumbar() {
		
	}
	
}





















