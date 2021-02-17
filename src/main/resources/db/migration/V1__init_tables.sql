CREATE TABLE municipios (
  codigoibge int NOT NULL,
  estado varchar(2) DEFAULT NULL,
  nomeibge varchar(255) DEFAULT NULL,
  paisvarchar varchar(255) DEFAULT NULL,
  PRIMARY KEY (codigoibge)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE gastos_periodo (
  id bigint NOT NULL AUTO_INCREMENT,
  ano_fim smallint DEFAULT NULL,
  ano_inicio smallint DEFAULT NULL,
  mes_fim varchar(2) DEFAULT NULL,
  mes_inicio varchar(2) DEFAULT NULL,
  total_gasto decimal(19,2) DEFAULT NULL,
  codigoibge int DEFAULT NULL,
  PRIMARY KEY (id),
  KEY fk_gastos_periodo_municipios (codigoibge),
  CONSTRAINT fk_gastos_periodo_municipios FOREIGN KEY (codigoibge) REFERENCES municipios (codigoibge)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;