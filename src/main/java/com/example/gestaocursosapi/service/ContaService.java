package com.example.gestaocursosapi.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.gestaocursosapi.model.Aluno;
import com.example.gestaocursosapi.model.Conta;
import com.example.gestaocursosapi.repository.ContaRepository;


@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;

	public List<Conta> findAll(){
		return (List<Conta>) contaRepository.findAll();
	}

	public Conta save(Conta conta) {
		return contaRepository.save(conta);
	}

	public Conta findOne(Long codigo) {
		return contaRepository.findOne(codigo);
	}

	public void delete(Long codigo) {
		contaRepository.delete(codigo); 
	}


	public Conta atualizar(final Long codigo, final Conta conta){
		Conta contaSalva = buscarContaPeloCodigo(codigo);
		
		BeanUtils.copyProperties(conta, contaSalva, "codigo");
		return contaRepository.save(contaSalva);
	}
	
	private Conta buscarContaPeloCodigo(final Long codigo) {
		Conta contaSalva = contaRepository.findOne(codigo);
		if(contaSalva == null){
			throw new EmptyResultDataAccessException(1); //espera pelomenos 1 elemento 
		}
		return contaSalva;
	}

}
