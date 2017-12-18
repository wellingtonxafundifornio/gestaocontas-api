package com.example.gestaocursosapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.gestaocursosapi.model.Turma;
import com.example.gestaocursosapi.repository.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository turmaRepository;

	public Turma atualizar(final Long codigo, final Turma turma){
		Turma turmaSalva = buscarTurmaPeloCodigo(codigo);
		
		BeanUtils.copyProperties(turma, turmaSalva, "codigo");
		return turmaRepository.save(turmaSalva);
	}
	
	public Turma buscarTurmaPeloCodigo(final Long codigo) {
		Turma turmaSalva = turmaRepository.findOne(codigo);
		if(turmaSalva == null){
			throw new EmptyResultDataAccessException(1); //espera pelomenos 1 elemento 
		}
		return turmaSalva;
	}

}
