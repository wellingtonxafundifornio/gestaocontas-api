package com.example.gestaocursosapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.gestaocursosapi.model.Conta;
import com.example.gestaocursosapi.model.Lancamento;
import com.example.gestaocursosapi.repository.ContaRepository;
import com.example.gestaocursosapi.repository.LancamentoRepository;
import com.example.gestaocursosapi.repository.filter.LancamentoFilter;
import com.example.gestaocursosapi.resource.FiltroLancamento;


@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private ContaRepository contaRepository;

	public Lancamento criar(Lancamento lancamento) {
		Conta conta;
		if(lancamento.getConta().getCodigo() != null){
			Lancamento lancamentoSalvo = lancamentoRepository.save(lancamento);
			lancamento.setConta( contaRepository.findOne(lancamento.getConta().getCodigo()) );
			if(lancamento.getOperacao().equalsIgnoreCase("Crédito")){
				lancamento.getConta().credita(lancamento.getValor());
			}else {
				lancamento.getConta().debita(lancamento.getValor());
			}
		}
		//atualiza a conta
		lancamento.setConta( contaRepository.save(lancamento.getConta()) );
		return lancamentoRepository.save(lancamento);
	}
	
	

	public List<Lancamento> listarTodos() {
		return (List<Lancamento>) lancamentoRepository.findAll();
	}

	public List<Lancamento> buscarPorConta(final Long codigo) {
		Conta conta = contaRepository.findOne(codigo);
		return lancamentoRepository.findByConta(conta);
	}

	public List<Lancamento> findByContaCodigoOrValor(FiltroLancamento filtroLancamento){
		return lancamentoRepository.findByContaCodigoOrValor(filtroLancamento.getCodigo(),filtroLancamento.getValor());			
	}
	
	public List<Lancamento> findByContaCodigoOrDataBetweenOrValor(FiltroLancamento filtroLancamento){
		return lancamentoRepository.findByContaCodigoOrDataBetweenOrValor(filtroLancamento.getCodigo(), 
				filtroLancamento.getPeriodoInicio(),filtroLancamento.getPeriodoFim(),filtroLancamento.getValor());
	}

	public List<Lancamento> filtrar(LancamentoFilter lancamentoFilter) {
		return lancamentoRepository.filtrar(lancamentoFilter);
	}

}
