package com.curso.modelo.entidad;

import java.util.List;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String telefono;

	// Relación de uno a uno con una sola tabla
	@Embedded
	//Si en el embeddable se indica un nombre de columna que no interesa
	//se puede 'sobreescribir'
	//Tambien se puede aplicar a la Herencia
	@AttributeOverrides({
		@AttributeOverride(name="ciudad", column=@Column(name="poblacion"))
	})
	private Direccion direccion;
	
	//Relación de uno a uno con dos tablas
	//Extremo opcional
	@OneToOne(mappedBy = "cliente", cascade=CascadeType.ALL)
	private DatosBancarios datosBancarios;
	
	//Relacion de uno a muchos
	//Extremo opcional
	@OneToMany(mappedBy="cliente", cascade=CascadeType.ALL /*, fetch = FetchType.EAGER*/) //Este cascade no es realmente necesario y el fetch EAGER una cosa peligrosísima
	//@Transient
	private List<Pedido> pedidos;
	
	//Relacion de muchos a muchos
	@ManyToMany(mappedBy="clientes", cascade=CascadeType.ALL) //Este cascade es una aberracion
	private List<Comercial> comerciales;
	

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(Integer id, String nombre, String telefono,
			Direccion direccion, DatosBancarios datosBancarios) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.datosBancarios = datosBancarios;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public DatosBancarios getDatosBancarios() {
		return datosBancarios;
	}

	public void setDatosBancarios(DatosBancarios datosBancarios) {
		this.datosBancarios = datosBancarios;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public List<Comercial> getComerciales() {
		return comerciales;
	}

	public void setComerciales(List<Comercial> comerciales) {
		this.comerciales = comerciales;
	}
	
}
