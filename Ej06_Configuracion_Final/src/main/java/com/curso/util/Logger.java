package com.curso.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Logger implements InitializingBean, DisposableBean {

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
	
	@Override
	//Este método será invocado por spring cuando la bean ya no sea necesaria
	public void destroy() throws Exception {
		System.out.println("destroy de Logger");
		bw.flush();	
		bw.close();
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
	
	/*
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("borrar.txt");
		BufferedWriter bw1 = new BufferedWriter(fw);
		bw1.write("HOLA QUE TAL");
		bw1.flush();
		
		
		OutputStream os = new FileOutputStream("datos-base64.txt");
		BufferedOutputStream bos = new BufferedOutputStream(os);
		OutputStream b64os = Base64.getEncoder().wrap(bos);
		
		
		b64os.write("OLA KE TAL".getBytes());
		b64os.flush();
	}
	*/
	
	
}
