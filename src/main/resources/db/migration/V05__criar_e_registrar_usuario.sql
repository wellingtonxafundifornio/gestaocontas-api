CREATE TABLE usuario (
	codigo BIGSERIAL PRIMARY KEY,
	login VARCHAR(50) NOT NULL,
	senha VARCHAR(50) NOT NULL
);

INSERT INTO usuario(login, senha) VALUES ('admin',123);