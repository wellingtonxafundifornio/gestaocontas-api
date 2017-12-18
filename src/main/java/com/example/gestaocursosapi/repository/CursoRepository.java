package com.example.gestaocursosapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestaocursosapi.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{

}
