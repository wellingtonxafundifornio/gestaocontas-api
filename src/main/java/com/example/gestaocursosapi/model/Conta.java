package com.example.gestaocursosapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "conta")
public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotNull
	private String nome;
	
	
	@Column(name = "valor")
	private Double valor;
	
	
	public Conta(Long codigo, String nome, Double valor) {
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
		
	}
	
	public Conta(){
		
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public void debita(Double valor){
		this.valor -= valor;
	}
	
	public void credita(Double valor){
		this.valor += valor;
	}
	
	

	
	
	
	

}
