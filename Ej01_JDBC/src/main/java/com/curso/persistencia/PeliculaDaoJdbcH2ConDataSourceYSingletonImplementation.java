package com.curso.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.curso.modelo.entidad.Pelicula;
import com.curso.persistencia.util.DataSourceUtil;

public class PeliculaDaoJdbcH2ConDataSourceYSingletonImplementation implements PeliculaDao{

	//SINGLETON///////////////////////////////////////////////////////////
	private static PeliculaDao instancia;
	
	static {
		instancia = new PeliculaDaoJdbcH2ConDataSourceYSingletonImplementation();
	}
	
	public static PeliculaDao getInstancia() {
		return instancia;
	}
	//////////////////////////////////////////////////////////////////////
	
	private PeliculaDaoJdbcH2ConDataSourceYSingletonImplementation() {
	}
		
	//
	//Este DAO implementa el antipatrón 'UNA CONEXIÓN POR CADA CONSULTA'
	//	
	
	@Override
	public void insertar(Pelicula pelicula) {
		
		//Los tres valores para crear la conexión los tendríamos en un fichero de configuración
		try ( Connection cx = DataSourceUtil.getDataSource().getConnection(); ) {
			//Las statements son:
			//-engorrosas por la concatenación de los valores
			//-menos eficientes que las prepared statements
			//-se comen con patatas la inyección de SQL
			//JAMAS UTILIZAREMOS STATEMENTS
			//Statement st = cx.createStatement();
			//st.executeUpdate("insert into PELICULAS (TITULO, DIRECTOR, GENERO, YEAR, SINOPSIS) values ('"+pelicula.getTitulo()+"','"+pelicula.getDirector()+"','"+pelicula.getGenero()+"',"+pelicula.getYear()+",'"+pelicula.getSinopsis()+"')");
			
			PreparedStatement pst = cx.prepareStatement("insert into PELICULAS (TITULO, DIRECTOR, GENERO, YEAR_, SINOPSIS) values (?, ?, ?, ?, ?)");
			pst.setString(1, pelicula.getTitulo());		
			pst.setString(2, pelicula.getDirector());		
			pst.setString(3, pelicula.getGenero());		
			pst.setInt(4, pelicula.getYear());		
			pst.setString(5, pelicula.getSinopsis());		
			pst.executeUpdate();
					
			/*
			Camel case : holaQueTal
			Pascal case: HolaQueTal
			Kebab case : hola-que-tal
			Snake case : HOLA_QUE_TAL
			*/
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}

	@Override
	public void modificar(Pelicula pelicula) {
		try ( Connection cx = DataSourceUtil.getDataSource().getConnection(); ) {
			PreparedStatement pst = cx.prepareStatement("uptade PELICULAS set TITULO=?, DIRECTOR=?, GENERO=?, YEAR_=?, SINOPSIS=? WHERE id=?");
			pst.setString(1, pelicula.getTitulo());		
			pst.setString(2, pelicula.getDirector());		
			pst.setString(3, pelicula.getGenero());		
			pst.setInt(4, pelicula.getYear());		
			pst.setString(5, pelicula.getSinopsis());		
			pst.setInt(6, pelicula.getId());		
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	@Override
	public void borrar(Pelicula pelicula) {
		try ( Connection cx = DataSourceUtil.getDataSource().getConnection(); ) {
			PreparedStatement pst = cx.prepareStatement("delete from PELICULAS WHERE id=?");
			pst.setInt(1, pelicula.getId());		
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 		
	}

	@Override
	public Pelicula buscar(Integer id) {		
		Pelicula p = null;
		
		try ( Connection cx = DataSourceUtil.getDataSource().getConnection(); ) {
			PreparedStatement pst = cx.prepareStatement("SELECT * from PELICULAS WHERE id=?");
			pst.setInt(1, id);		
			ResultSet rs = pst.executeQuery();
			/*
			rs.first();
			rs.last();
			rs.beforeFirst();
			rs.afterLast()
			*/
			if(rs.next()) {
				p = new Pelicula(
						rs.getInt("ID"), 
						rs.getString("TITULO"), 
						rs.getString("DIRECTOR"), 
						rs.getString("GENERO"), 
						rs.getInt("YEAR_"), 
						rs.getString("SINOPSIS")
					);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}

	@Override
	public List<Pelicula> listar() {
		
		List<Pelicula> peliculas = new ArrayList<>();
		
		try ( Connection cx = DataSourceUtil.getDataSource().getConnection(); ) {
			PreparedStatement pst = cx.prepareStatement("SELECT * from PELICULAS");
			ResultSet rs = pst.executeQuery();

			while(rs.next()) {
				Pelicula p = new Pelicula(
						rs.getInt("ID"), 
						rs.getString("TITULO"), 
						rs.getString("DIRECTOR"), 
						rs.getString("GENERO"), 
						rs.getInt("YEAR_"), 
						rs.getString("SINOPSIS")
					);
				peliculas.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return peliculas;
	}

}
