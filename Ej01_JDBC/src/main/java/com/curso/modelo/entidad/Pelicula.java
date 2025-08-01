package com.curso.modelo.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name="PELICULAS")
public class Pelicula {

	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private String director;
	private String genero;
	//@Column(name="YEAR_")
	private Integer year;
	private String sinopsis;

	public Pelicula() {
		super();
	}

	public Pelicula(Integer id, String titulo, String director, String genero, Integer year, String sinopsis) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.director = director;
		this.genero = genero;
		this.year = year;
		this.sinopsis = sinopsis;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	@Override
	public String toString() {
		return super.toString()+" [id=" + id + ", titulo=" + titulo + ", director=" + director + ", genero=" + genero + ", year="
				+ year + ", sinopsis=" + sinopsis + "]";
	}

}
