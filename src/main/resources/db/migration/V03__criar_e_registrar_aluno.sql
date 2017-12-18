CREATE TABLE aluno (
	codigo	BIGSERIAL PRIMARY KEY,
	nome	VARCHAR(80) NOT NULL,
	nota_1	DECIMAL,
	nota_2	DECIMAL,
	nota_3	DECIMAL,
	codigo_turma BIGINT NOT NULL,
	FOREIGN KEY (codigo_turma) REFERENCES turma(codigo)
);

INSERT INTO aluno (nome, nota_1, nota_2, nota_3, codigo_turma) VALUES ('João Lucas', 9.9, 6.0, 7.0, 1);
INSERT INTO aluno (nome, nota_1, nota_2, nota_3, codigo_turma) VALUES ('Maria Fernanda', 8.5, 5.0, 9.0, 2);
INSERT INTO aluno (nome, nota_1, nota_2, nota_3, codigo_turma) VALUES ('Luis Augusto', 3.5, 7.0, 6.0, 3);