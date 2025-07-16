package com.curso.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

//Ciclo de vida de una bean de Spring
//-----------------------------------
//1-Se instancia el objeto con .getClass().getConstructor(...).newInstance()
//2-Se inicializan los atributos de la clase (esto es Java)
//3-Se invoca el constructor 
//4-Se inyectan las dependencias
//5-Si la clase implementa 'InitializingBean' spring invoca 'AfterPropertiesSet'
//6-Si se cierra el contendedor de Spring y la bean implementa 'DisposableBean' se invoca 'destroy'
//7-FIN

//@Component
public class Logger implements InitializingBean, DisposableBean {

	//@Value("log.txt")
	private String nombreFichero;
	private BufferedWriter bw;
	
	//Cuando se está ejecutando el constructor todavia no se han inyectado las dependencias
	//Es demasiado pronto...
	public Logger() {
		super();
		System.out.println("Instanciando Logger");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		//Aqui ya tenemos inyectadas las dependencias
		//Esto es una suerte de constructor diferido
		System.out.println("afterPropertiesSet de Logger");
		try {
			System.out.println("NombreFichero:"+nombreFichero);
			FileWriter fw = new FileWriter(nombreFichero);
			bw = new BufferedWriter(fw);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	//Si no queremos implementar initializing bean podemos marcar cualquier método
	//con @PostConstruct (Es una anotación de JEE)
	//Si spring la ve, invoca el métoido despues de resolver las dependencias
	//@PostConstruct
	public void inicializar() {
		//Aqui ya se han inyectado todas las dependecias
	}
	
	@Override
	//Este método será invocado por spring cuando la bean ya no sea necesaria
	public void destroy() throws Exception {
		System.out.println("destroy de Logger");
		bw.flush();	
		bw.close();
	}
	
	//Si no queremos implementar DisposableBean podemos marcar cualquier método con 
	//@PreDestroy y spring lo invocará antes de desacerse del objeto
	//@PreDestroy
	public void adiosMundoCruel() {
		//
	}
	
	//Es Spring el que inyecta aqui el valor con el nombre del fichero
	public void setNombreFichero(String nombreFichero) {
		this.nombreFichero = nombreFichero;
	}
	
	public synchronized void escribir(String texto) {
		try {
			bw.write(texto);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

/*
class Coche {

	private int x = 1;
	private LocalDateTime horaCreacion = LocalDateTime.now();
	private String marca;
	private String modelo;
	
	public Coche(int x) {
		super();
		this.x=x;
	}
	
}
*/






