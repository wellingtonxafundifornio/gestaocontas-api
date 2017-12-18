package com.example.gestaocursosapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestaocursosapi.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long>{

}
