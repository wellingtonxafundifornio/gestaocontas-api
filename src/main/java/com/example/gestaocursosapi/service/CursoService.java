package com.example.gestaocursosapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.gestaocursosapi.model.Curso;
import com.example.gestaocursosapi.repository.CursoRepository;

@Service
public class CursoService {

	@Autowired
	CursoRepository cursoRepository;
	
	
	public Curso atualizar(final Long codigo, final Curso curso){
		Curso cursoSalvo = buscarCursoPeloCodigo(codigo);
		
		BeanUtils.copyProperties(curso, cursoSalvo, "codigo");
		return cursoRepository.save(cursoSalvo);
	}
	
	public Curso buscarCursoPeloCodigo(final Long codigo) {
		Curso cursoSalvo = cursoRepository.findOne(codigo);
		if(cursoSalvo == null){
			throw new EmptyResultDataAccessException(1); //espera pelomenos 1 elemento 
		}
		return cursoSalvo;
	}
}
