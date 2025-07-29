package com.curso.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Logger implements InitializingBean, DisposableBean {

	private String nombreFichero;
	private BufferedWriter bw;
	
	public Logger() {
		super();
		System.out.println("Instanciando Logger");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
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
	public void destroy() throws Exception {
		System.out.println("destroy de Logger");
		bw.close();
	}	

	public void setNombreFichero(String nombreFichero) {
		this.nombreFichero = nombreFichero;
	}
	
	public synchronized void escribir(String texto) {
		try {
			bw.write(texto+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
