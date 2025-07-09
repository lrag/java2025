package com.curso.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.curso.modelo.entidad.Pelicula;

public class PeliculaDaoJdbcH2Implementation implements PeliculaDao{

	@Override
	public void insertar(Pelicula pelicula) {
		
		//Los tres valores para crear la conexión los tendríamos en un fichero de configuración
		try ( Connection cx = DriverManager.getConnection("jdbc:h2:C:/H2/bbdd_peliculas_2025","sa","");	) {
			//Las statements son:
			//-engorrosas por la concatenación de los valores
			//-menos eficientes que las prepared statements
			//-se comen con patatas la inyección de SQL
			//JAMAS UTILIZAREMOS STATEMENTS
			//Statement st = cx.createStatement();
			//st.executeUpdate("insert into PELICULAS (TITULO, DIRECTOR, GENERO, YEAR, SINOPSIS) values ('"+pelicula.getTitulo()+"','"+pelicula.getDirector()+"','"+pelicula.getGenero()+"',"+pelicula.getYear()+",'"+pelicula.getSinopsis()+"')");
			
			PreparedStatement pst = cx.prepareStatement("insert into PELICULAS (TITULO, DIRECTOR, GENERO, YEAR, SINOPSIS) values (?, ?, ?, ?, )");
			pst.setString(0, pelicula.getTitulo());		
			pst.setString(1, pelicula.getDirector());		
			pst.setString(2, pelicula.getGenero());		
			pst.setInt(3, pelicula.getYear());		
			pst.setString(4, pelicula.getSinopsis());		
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
		try ( Connection cx = DriverManager.getConnection("jdbc:h2:C:/H2/bbdd_peliculas_2025","sa","");	) {
			PreparedStatement pst = cx.prepareStatement("uptade PELICULAS set TITULO=?, DIRECTOR=?, GENERO=?, YEAR=?, SINOPSIS=? WHERE id=?");
			pst.setString(0, pelicula.getTitulo());		
			pst.setString(1, pelicula.getDirector());		
			pst.setString(2, pelicula.getGenero());		
			pst.setInt(3, pelicula.getYear());		
			pst.setString(4, pelicula.getSinopsis());		
			pst.setInt(5, pelicula.getId());		
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	@Override
	public void borrar(Pelicula pelicula) {
		try ( Connection cx = DriverManager.getConnection("jdbc:h2:C:/H2/bbdd_peliculas_2025","sa","");	) {
			PreparedStatement pst = cx.prepareStatement("delete from PELICULAS WHERE id=?");
			pst.setInt(0, pelicula.getId());		
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 		
	}

	@Override
	public Pelicula buscar(Integer id) {		
		Pelicula p = null;
		
		try ( Connection cx = DriverManager.getConnection("jdbc:h2:C:/H2/bbdd_peliculas_2025","sa","");	) {
			PreparedStatement pst = cx.prepareStatement("SELECT from PELICULAS WHERE id=?");
			pst.setInt(0, id);		
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
						rs.getInt("YEAR"), 
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
		
		try ( Connection cx = DriverManager.getConnection("jdbc:h2:C:/H2/bbdd_peliculas_2025","sa","");	) {
			PreparedStatement pst = cx.prepareStatement("SELECT from PELICULAS");
			ResultSet rs = pst.executeQuery();

			while(rs.next()) {
				Pelicula p = new Pelicula(
						rs.getInt("ID"), 
						rs.getString("TITULO"), 
						rs.getString("DIRECTOR"), 
						rs.getString("GENERO"), 
						rs.getInt("YEAR"), 
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
