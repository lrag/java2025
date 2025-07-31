package com.curso.modelo.persistencia;

import java.util.List;

import com.curso.modelo.entidad.Pelicula;

public interface PeliculaDao {

	void insertar(Pelicula pelicula);
	void modificar(Pelicula pelicula);
	void borrar(Pelicula pelicula);
	void borrarPeliculas();
	Pelicula buscar(Integer id);
	List<Pelicula> listar();

}