CREATE TABLE turma (
	codigo 				BIGSERIAL PRIMARY KEY,
	hora_inicio			VARCHAR(2),
	minuto_inicio		VARCHAR(2),
	hora_fim			VARCHAR(2),
	minuto_fim			VARCHAR(2),
	codigo_curso BIGINT NOT NULL,
	FOREIGN KEY (codigo_curso) REFERENCES curso(codigo)
);

INSERT INTO turma (hora_inicio, minuto_inicio, hora_fim, minuto_fim, codigo_curso) VALUES ('7','30','11','30', 1);
INSERT INTO turma (hora_inicio, minuto_inicio, hora_fim, minuto_fim, codigo_curso) VALUES ('9','30','13','15', 2);
INSERT INTO turma (hora_inicio, minuto_inicio, hora_fim, minuto_fim, codigo_curso) VALUES ('18','30', '22','45',3);

