package com.curso.modelo.negocio;

import com.curso.util.Logger;

public class GestorClientes {

	private Logger logger;
	private Logger loggerError;

	public GestorClientes() {
		super();
		System.out.println("Instanciando GestorClientes");
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public void setLoggerError(Logger loggerError) {
		this.loggerError = loggerError;
	}

	public void altaCliente(String cliente) {

		System.out.println("Insertando el cliente:" + cliente);
		logger.escribir("TODO BIEN");
		loggerError.escribir("ZASCA!");

	}

}
