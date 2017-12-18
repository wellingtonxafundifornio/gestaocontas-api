package com.example.gestaocursosapi.resource;

import java.util.Date;

public class FiltroLancamento {

	private Long codigo;
	private Date periodoInicio;
	private Date periodoFim;
	private Double valor;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public Date getPeriodoInicio() {
		return periodoInicio;
	}
	public void setPeriodoInicio(Date periodoInicio) {
		this.periodoInicio = periodoInicio;
	}
	public Date getPeriodoFim() {
		return periodoFim;
	}
	public void setPeriodoFim(Date periodoFim) {
		this.periodoFim = periodoFim;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	
}
