package com.example.gestaocursosapi.model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Lancamento.class)
public abstract class Lancamento_ {

	public static volatile SingularAttribute<Lancamento, Long> codigo;
	public static volatile SingularAttribute<Lancamento, LocalDate> data;
	public static volatile SingularAttribute<Lancamento, String> operacao;
	public static volatile SingularAttribute<Lancamento, Conta> conta;
	public static volatile SingularAttribute<Lancamento, Double> valor;

}

