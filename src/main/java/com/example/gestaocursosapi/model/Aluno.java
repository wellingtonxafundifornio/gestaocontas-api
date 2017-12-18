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
@Table(name = "aluno")
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotNull
	private String nome;
	
	
	@Column(name = "nota_1")
	private Double nota1;
	
	
	@Column(name = "nota_2")
	private Double nota2;
	
	
	@Column(name = "nota_3")
	private Double nota3;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "codigo_turma")
	private Turma turma;

	public Aluno(String nome, Double nota1, Double nota2, Double nota3, Turma turma) {
		this.nome = nome;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
		this.turma = turma;
	}
	
	public Aluno(){
		
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

	public Double getNota1() {
		return nota1;
	}

	public void setNota1(Double nota1) {
		this.nota1 = nota1;
	}

	public Double getNota2() {
		return nota2;
	}

	public void setNota2(Double nota2) {
		this.nota2 = nota2;
	}

	public Double getNota3() {
		return nota3;
	}

	public void setNota3(Double nota3) {
		this.nota3 = nota3;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	
	
	

}
