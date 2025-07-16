package com.curso.modelo.entidad;

import java.util.Properties;

public class Seguro extends AbstractBean {
	
	private String numPoliza;
	private Properties coberturas; 

	public Seguro() {
		super();
	}

	public Seguro(String numPoliza) {
		super();
		this.numPoliza = numPoliza;
	}

	public String getNumPoliza() {
		return numPoliza;
	}

	public void setNumPoliza(String numPoliza) {
		this.numPoliza = numPoliza;
	}

	public Properties getCoberturas() {
		return coberturas;
	}

	public void setCoberturas(Properties coberturas) {
		this.coberturas = coberturas;
	}
	
	

}
