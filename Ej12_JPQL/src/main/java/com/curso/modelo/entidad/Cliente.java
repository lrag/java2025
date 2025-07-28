package com.curso.modelo.entidad;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
@NamedQueries( {
	@NamedQuery(name="cliente.listarTodos",query="select c from Cliente c"),
	@NamedQuery(name="cliente.listarPorCiudad",query="select c from Cliente c where c.direccion.ciudad=:ciudad")
	}
)
public class Cliente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String telefono;

	//Relación de uno a uno con una sola tabla
	@Embedded
	private Direccion direccion;
	
	//Relación de uno a uno con dos tablas, extremo obligatorio
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_id_datos_bancarios", referencedColumnName="id")
	private DatosBancarios datosBancarios;
	
	//Relacion de uno a muchos, extremo opcional
	@OneToMany(mappedBy="cliente", cascade=CascadeType.ALL) //, fetch=FetchType.EAGER)
	private List<Pedido> pedidos;
	
	//Relacion de uno a muchos, extremo opcional
	@OneToMany(mappedBy="cliente", cascade=CascadeType.ALL) //, fetch=FetchType.EAGER)
	private List<Factura> facturas; 
	
	@ManyToMany(cascade=CascadeType.ALL) //Este cascade es una aberracion
	@JoinTable(name="comerciales_clientes",
			   joinColumns= { @JoinColumn(name="fk_id_cliente", referencedColumnName="id") }, //FK que aporta Cliente
			   inverseJoinColumns= { @JoinColumn(name="fk_id_comercial", referencedColumnName="id")}) //FKs que aportan el resto de entidades
	private List<Comercial> comerciales;

	public Cliente() {
		super();
	}

	public Cliente(Integer id, String nombre, Direccion direccion,
			String telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
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

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setDatosBancarios(DatosBancarios datosBancarios) {
		this.datosBancarios = datosBancarios;
	}

	public DatosBancarios getDatosBancarios() {
		return datosBancarios;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}
	
	

}
