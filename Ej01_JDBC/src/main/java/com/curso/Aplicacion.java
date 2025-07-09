package com.curso;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


public class Aplicacion {

	public static void main(String[] args) throws SQLException {
		
		//      //
		//A MANO//
		//      //
		/*
		//Creamos el driver (necesitamos importar la implementación, asi que ya vamos mal)
		//El driver hay que crearlo solo una vez
		org.h2.Driver d = new org.h2.Driver();
		//Al driver ya le podemos pedir conexiones (pero es engorroso)
		Connection cx1 = d.connect("", null);
		
		//Lo correcto es registrar el driver en el DriverManager
		DriverManager.registerDriver(d);
		//Y ya le pedimos las conexiónes al DriverManager
		Connection cx2 = DriverManager.getConnection("jdbc:h2:C:/H2/bbdd_peliculas_2025","sa","");
		*/
		
		//         //
		//A MÁQUINA//
		//         //

		//El proceso de instaciación del driver y su registro en el driver manager es completamente automático desde JDBC4.0
		
		try {
			//El nombre de la clase estaría en un fichero de configuración
			Class driverClass = Class.forName("org.h2.Driver");
			//Class.newInstance crea una instancia de la clase invocando el constructor escogido
			Driver d2 = (Driver) driverClass.getConstructor().newInstance();
			DriverManager.registerDriver(d2);		
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		///////////////////////////////////////
		Connection cx = DriverManager.getConnection("jdbc:h2:C:/H2/bbdd_peliculas_2025","sa","");
		System.out.println(cx);
		
		
	}
	
}


class Cliente {	
	String nombre;
	List<String> direccion;
	String telefono;	
}

class Campo {
	String nombre;
	String tipo;
	String modificadorAcceso;	
}

class Metodo{
	//...
}

class Clase {	
	String nombre;
	List<Campo> fields;
	List<Metodo> metodos;
	//..	
}




