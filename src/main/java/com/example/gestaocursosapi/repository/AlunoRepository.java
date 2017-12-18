package com.example.gestaocursosapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestaocursosapi.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

}
