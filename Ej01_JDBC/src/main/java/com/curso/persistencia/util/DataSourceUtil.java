package com.curso.persistencia.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DataSourceUtil {

	//Podríamos inicializar el DS en un inicializador estático
	private static DataSource ds;

	/*Así sería inicialización ansiosa
	static {
		HikariConfig hkCfg = new HikariConfig();
		hkCfg.setJdbcUrl("jdbc:h2:C:/H2/bbdd_peliculas_2025");
		hkCfg.setDriverClassName("org.h2.Driver");
		hkCfg.setUsername("sa");
		hkCfg.setPassword("");
		ds = new HikariDataSource(hkCfg);		
	}
	*/
	
	public synchronized static DataSource getDataSource() {
	
		//Inicialización perezosa
		if(ds == null) {
			HikariConfig hkCfg = new HikariConfig();
			hkCfg.setJdbcUrl("jdbc:h2:C:/H2/bbdd_peliculas_2025");
			hkCfg.setDriverClassName("org.h2.Driver");
			hkCfg.setUsername("sa");
			hkCfg.setPassword("");
			ds = new HikariDataSource(hkCfg);			
		}		
		
		return ds;
	}
	
	public static Connection getConnection() throws SQLException {
		return getDataSource().getConnection();
	}
	
}
