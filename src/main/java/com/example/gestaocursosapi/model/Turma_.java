package com.example.gestaocursosapi.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Turma.class)
public abstract class Turma_ {

	public static volatile SingularAttribute<Turma, String> minutoInicio;
	public static volatile SingularAttribute<Turma, String> horaFim;
	public static volatile SingularAttribute<Turma, Long> codigo;
	public static volatile SingularAttribute<Turma, String> minutoFim;
	public static volatile SingularAttribute<Turma, Curso> curso;
	public static volatile SingularAttribute<Turma, String> horaInicio;

}

