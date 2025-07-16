package com.curso.modelo.entidad;

import java.io.Serializable;

public class AbstractBean implements Serializable{

	private static final long serialVersionUID = 1623458772090020636L;

	public AbstractBean() {
		super();
	}

	@Override
	public String toString() {
		return super.toString()+" AbstractBean []";
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

}