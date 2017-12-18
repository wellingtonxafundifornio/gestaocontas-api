package com.example.gestaocursosapi.repository.filter;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class LancamentoFilter {
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataInicial;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataFinal;

	public LocalDate getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}

	public LancamentoFilter(LocalDate dataInicial, LocalDate dataFinal) {
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
	}

	public LancamentoFilter() {
	}	
	
	
	
	
	
	

}
