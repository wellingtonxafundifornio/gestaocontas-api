package com.example.gestaocursosapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.gestaocursosapi.model.Aluno;
import com.example.gestaocursosapi.repository.AlunoRepository;


@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	public Aluno atualizar(final Long codigo, final Aluno aluno){
		Aluno alunoSalvo = buscarAlunoPeloCodigo(codigo);
		
		BeanUtils.copyProperties(aluno, alunoSalvo, "codigo");
		return alunoRepository.save(alunoSalvo);
	}
	
	public Aluno buscarAlunoPeloCodigo(final Long codigo) {
		Aluno alunoSalvo = alunoRepository.findOne(codigo);
		if(alunoSalvo == null){
			throw new EmptyResultDataAccessException(1); //espera pelomenos 1 elemento 
		}
		return alunoSalvo;
	}

}
