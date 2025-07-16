package com.curso.modelo.entidad;

public class Pelicula {

	private Integer id;
	private String titulo;
	private Director director;
	private String genero;

	// alt+shift+s c
	// alt+shift+s o
	// alt+shift+s r
	// alt+shift+s s

	public Pelicula() {
		super();
		System.out.println("Creando una película");
	}

	public Pelicula(Integer id, String titulo, Director director, String genero) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.director = director;
		this.genero = genero;
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

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", director=" + director + ", genero=" + genero + "]";
	}

}
