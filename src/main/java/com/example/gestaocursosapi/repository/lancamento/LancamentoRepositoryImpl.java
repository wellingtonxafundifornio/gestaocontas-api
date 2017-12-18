package com.example.gestaocursosapi.repository.lancamento;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.example.gestaocursosapi.model.Lancamento;
import com.example.gestaocursosapi.model.Lancamento_;
import com.example.gestaocursosapi.repository.filter.LancamentoFilter;

public class LancamentoRepositoryImpl {

	@PersistenceContext // ingeta o EntityManager
	private EntityManager manager;

	
	public List<Lancamento> filtrar(LancamentoFilter lancamentoFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Lancamento> criteria = builder.createQuery(Lancamento.class); 

		Root<Lancamento> root = criteria.from(Lancamento.class);

		//cria as restrições
		Predicate[] predicates = criarRestricoes(lancamentoFilter, builder, root);
		criteria.where(predicates);

		TypedQuery<Lancamento> query = manager.createQuery(criteria);
		
		return new ArrayList<Lancamento>(query.getResultList());
	}
	
	private Predicate[] criarRestricoes(final LancamentoFilter lancamentoFilter, final CriteriaBuilder builder,
			final Root<Lancamento> root) {
		List<Predicate> predicates = new ArrayList<>();

		if (lancamentoFilter.getDataInicial() != null) {
			predicates.add(
					builder.greaterThanOrEqualTo(root.get(Lancamento_.data), lancamentoFilter.getDataInicial())
					);
		}

		if (lancamentoFilter.getDataFinal() != null){
			predicates.add(
					builder.lessThanOrEqualTo(root.get(Lancamento_.data), lancamentoFilter.getDataFinal())
					);
		}
			return predicates.toArray(new Predicate[predicates.size()]);
	}
}
