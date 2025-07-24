package com.curso.modelo.entidad;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Factura {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_factura")
	private int idFactura;
	private String codigo;
	private Date fecha;

	//Este extremo de la relaci�n es obligatorio
	@ManyToOne
	@JoinColumn(name="fk_id_cliente", referencedColumnName="id")
	private Cliente cliente;

	public Factura() {
		super();
	}

	public Factura(int idFactura, String codigo, Date fecha, Cliente cliente) {
		super();
		this.idFactura = idFactura;
		this.codigo = codigo;
		this.fecha = fecha;
		this.cliente = cliente;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Factura [idFactura=" + idFactura + ", codigo=" + codigo
				+ ", fecha=" + fecha + ", cliente=" + cliente + "]";
	}

}
