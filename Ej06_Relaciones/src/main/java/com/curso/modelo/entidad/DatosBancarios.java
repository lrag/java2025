package com.curso.modelo.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "datos_bancarios")
public class DatosBancarios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String banco;
	@Column(name = "numero_tc")
	private Integer numeroTC;

	//Relación de uno a uno con dos tablas
	//Extremo obligatorio (La FK está en la tabla 'datos_bancarios')
	@OneToOne/*(cascade= CascadeType.ALL)*/ //Este cascade claramente sobra
	@JoinColumn(name = "fk_id_cliente", referencedColumnName = "id")
	private Cliente cliente;

	public DatosBancarios() {
		super();
	}

	public DatosBancarios(Integer id, String banco, Integer numeroTC,
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

	public Integer getNumeroTC() {
		return numeroTC;
	}

	public void setNumeroTC(Integer numeroTC) {
		this.numeroTC = numeroTC;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
