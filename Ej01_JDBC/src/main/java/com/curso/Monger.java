package com.curso;

public class Monger {

	public static String datoEstático;
	
	static {
		System.out.println("Inicializador estático de la clase Monger");
		datoEstático = "MOVIDA";
	}
	
	public String dato;
	
	//Los inicializadores dinámicos se ejecutan cuando se instancia la clase, se utilice el constructor que se utilice
	{
		System.out.println("Inicializador dinámico de la clase Monger");
		dato = "HOLA";
	}

	public Monger() {
		super();
		System.out.println("Constructor sin parámetros de la clase Monger");		
	}
	
	public Monger(int a) {
		super();
		System.out.println("Constructor con parámetros de la clase Monger");		
	}
	
}
