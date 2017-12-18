CREATE TABLE curso(
	codigo		BIGSERIAL PRIMARY KEY,
	nome		VARCHAR(80)
);

INSERT INTO curso (nome) VALUES ('Java');
INSERT INTO curso (nome) VALUES ('Banco de dados Oralce');
INSERT INTO curso (nome) VALUES ('Android');