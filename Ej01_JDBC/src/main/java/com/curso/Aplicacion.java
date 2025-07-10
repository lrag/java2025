package com.curso;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.curso.modelo.entidad.Pelicula;
import com.curso.persistencia.PeliculaDao;
import com.curso.persistencia.PeliculaDaoJdbcH2Implementation;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


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
		System.out.println("Conexión obtenida del DriverManager: "+cx+", "+cx.getClass().getName());
		cx.close();
		System.out.println();
		
		
		try {
			Class.forName("com.curso.Monger").getConstructor().newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		///////////////////////////////////////////////////////////////////////////
		
		Pelicula p1 = new Pelicula(null,"Alien","RS","CiFi",1979,"En el espacio nadie puede oirte gritar");
		PeliculaDao peliculaDao = new PeliculaDaoJdbcH2Implementation();
		//peliculaDao.insertar(p1);
		List<Pelicula> peliculas = peliculaDao.listar();
		for(Pelicula p: peliculas) {
			System.out.println(p);
		}
		
		///////////////////////////////////////////////////////////////////////////
		
		//DataSource ds;
		//ds.getConnection();
		
		
		
		HikariConfig hkCfg = new HikariConfig();
		hkCfg.setJdbcUrl("jdbc:h2:C:/H2/bbdd_peliculas_2025");
		hkCfg.setDriverClassName("org.h2.Driver");
		hkCfg.setUsername("sa");
		hkCfg.setPassword("");			
		
		DataSource ds = new HikariDataSource(hkCfg);
		
		Connection cx3 = ds.getConnection();
		System.out.println("Conexión obtenida del data source: "+cx3+", "+cx3.getClass().getName());
		cx3.close();
		
		
		Cliente c = new Cliente();
		c.setNombre("Ringo Starr");
		c.setDireccion("C/Su calle");
		
		Cliente c2 = new Cliente()
			.setNombre("Ripley")
			.setDireccion("C/Falsa, 123")
			.setTelefono("555123456");
		
	}
	
}


class Cliente {	
	String nombre;
	String direccion;
	String telefono;
	
	public Cliente setNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}
	
	public Cliente setDireccion(String direccion) {
		this.direccion = direccion;
		return this;
	}
	
	public Cliente setTelefono(String telefono) {
		this.telefono = telefono;
		return this;
	}
	
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




