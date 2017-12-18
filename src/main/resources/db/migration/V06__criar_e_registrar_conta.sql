CREATE TABLE conta (
	codigo BIGSERIAL PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	valor numeric(10,5) NOT NULL
);

INSERT INTO conta(nome, valor) VALUES ('caixa',140.00);