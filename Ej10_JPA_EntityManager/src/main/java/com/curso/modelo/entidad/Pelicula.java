package com.curso.modelo.entidad;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

//Clases de acceso público
//No final
//Con constructor por defecto
//Con getters y setters
//En esencia: una java bean

@Entity //Obligatoria
@Table(name = "peliculas") // Opcional
public class Pelicula {

	@Id // Obligatoria
	//@GeneratedValue(strategy = GenerationType.UUID) 
	//private UUID id;
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PELICULAS_SEQ")
	//@SequenceGenerator(name = "PELICULAS_SEQ", initialValue = 0, allocationSize = 10)
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Columna autoincremental
	private Integer id;

	private String titulo;
	private String genero;
	private int duracion;
	
	@Column(name = "fecha_estreno")	
	//Se puede trabajar con java.util.Date (a la antígua)
	//@Temporal(TemporalType.DATE) Opcional: si no se incluye se guarda el timestamp
	//private Date fecha;
	private LocalDate fechaEstreno;

	@Transient
	private String DatoQueNoQueremosQueSePersista;
	private transient String DatoQueNoQueremosQueSePersistaNiQueSeSerialize;

	public Pelicula() {
		super();
	}

	public Pelicula(Integer id, String titulo, String genero, int duracion, LocalDate fechaEstreno) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.genero = genero;
		this.duracion = duracion;
		this.fechaEstreno = fechaEstreno;
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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public LocalDate getFechaEstreno() {
		return fechaEstreno;
	}

	public void setFechaEstreno(LocalDate fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	public String getDatoQueNoQueremosQueSePersista() {
		return DatoQueNoQueremosQueSePersista;
	}

	public void setDatoQueNoQueremosQueSePersista(String datoQueNoQueremosQueSePersista) {
		DatoQueNoQueremosQueSePersista = datoQueNoQueremosQueSePersista;
	}

	public String getDatoQueNoQueremosQueSePersistaNiQueSeSerialize() {
		return DatoQueNoQueremosQueSePersistaNiQueSeSerialize;
	}

	public void setDatoQueNoQueremosQueSePersistaNiQueSeSerialize(
			String datoQueNoQueremosQueSePersistaNiQueSeSerialize) {
		DatoQueNoQueremosQueSePersistaNiQueSeSerialize = datoQueNoQueremosQueSePersistaNiQueSeSerialize;
	}

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", genero=" + genero + ", duracion=" + duracion
				+ ", fechaEstreno=" + fechaEstreno + "]";
	}

}
