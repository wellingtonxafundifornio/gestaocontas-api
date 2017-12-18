package com.example.gestaocursosapi.repository.lancamento;

import java.util.List;

import com.example.gestaocursosapi.model.Lancamento;
import com.example.gestaocursosapi.repository.filter.LancamentoFilter;

public interface LancamentoRepositoryQuery {

	public List<Lancamento> filtrar(final LancamentoFilter lancamentoFilter);
}
