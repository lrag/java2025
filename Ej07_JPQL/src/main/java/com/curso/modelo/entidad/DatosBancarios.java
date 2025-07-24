package com.curso.modelo.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "datos_bancarios")
public class DatosBancarios {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String banco;
	@Column(name = "numero_tc")
	private Long numeroTC;

	//Relaci�n de uno a uno, extremo opcional
	@OneToOne(mappedBy="datosBancarios")
	private Cliente cliente;

	public DatosBancarios() {
		super();
	}

	public DatosBancarios(Integer id, String banco, Long numeroTC,
			Cliente cliente) {
		super();
		this.id = id;
		this.banco = banco;
		this.numeroTC = numeroTC;
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public Long getNumeroTC() {
		return numeroTC;
	}

	public void setNumeroTC(Long numeroTC) {
		this.numeroTC = numeroTC;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
