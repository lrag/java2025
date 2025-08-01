package com.curso.modelo.entidad;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Factura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String codigo;
	private Double total;
	private LocalDate fecha;
	@ManyToOne
	@JoinColumn(name = "fk_id_cliente")
	private Cliente cliente;

	public Factura() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Factura(Integer id, String codigo, Double total, LocalDate fecha, Cliente cliente) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.total = total;
		this.fecha = fecha;
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
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
		return "Factura [id=" + id + ", codigo=" + codigo + ", total=" + total + ", fecha=" + fecha + ", cliente="
				+ cliente + "]";
	}

}
