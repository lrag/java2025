
package com.curso.persistencia;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.curso.modelo.entidad.Pelicula;

public class PeliculaDao {

	private DataSource dataSource;
	
	public PeliculaDao() {
		super();
		System.out.println("Creando un PeliculaDao");
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void insertar(Pelicula pelicula){
		Connection cx = null;
		try {	
			cx = dataSource.getConnection();
			System.out.println(cx);
			//PreparedStatement pst = cx.prepareStatement("insert into peliculas (titulo, genero, director) values (?,?,?)");
			//pst.setString(1, pelicula.getTitulo());
			//pst.setString(2, pelicula.getGenero());
			//pst.setString(3, palicula.getDirector().getNombre());
			//pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}
	
}
