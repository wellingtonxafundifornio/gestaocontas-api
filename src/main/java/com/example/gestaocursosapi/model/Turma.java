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
@Table(name = "turma")
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotNull
	@Column(name = "hora_inicio")
	private String horaInicio; 
	
	@NotNull
	@Column(name = "minuto_inicio")
	private String minutoInicio;
	
	@NotNull
	@Column(name = "hora_fim")
	private String horaFim;
	
	@NotNull
	@Column(name = "minuto_fim")
	private String minutoFim;

	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "codigo_curso")
	private Curso curso; 
	
	public Turma(){
		
	}

	public Turma(String horaInicio, String horaFim, Curso curso) {
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.curso = curso;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(String horaFim) {
		this.horaFim = horaFim;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
	

	public String getMinutoInicio() {
		return minutoInicio;
	}

	public void setMinutoInicio(String minutoInicio) {
		this.minutoInicio = minutoInicio;
	}

	public String getMinutoFim() {
		return minutoFim;
	}

	public void setMinutoFim(String minutoFim) {
		this.minutoFim = minutoFim;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turma other = (Turma) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	

	
}
