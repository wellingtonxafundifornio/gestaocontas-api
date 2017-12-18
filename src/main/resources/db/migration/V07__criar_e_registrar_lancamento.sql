CREATE TABLE lancamento
(
  codigo 		BIGSERIAL PRIMARY KEY,
  operacao 		VARCHAR(50),
  data   		timestamp without time zone,
  valor 		DECIMAL,
  conta_codigo  BIGINT NOT NULL,
  FOREIGN KEY (conta_codigo) REFERENCES conta(codigo)
);

INSERT INTO conta(nome, valor) VALUES ('Santander',1000.00);
INSERT INTO conta(nome, valor) VALUES ('Itau',1000.00);

insert into lancamento (operacao, data, valor, conta_codigo)
values ('Crédito', to_date('02/11/2017', 'DD/MM/YYYY'), 1000, 1);

insert into lancamento (operacao, data, valor, conta_codigo)
values ('Débito', to_date('02/11/2017', 'DD/MM/YYYY'), 1000, 3);