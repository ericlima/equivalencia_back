CREATE TABLE `ies_mec` (
  `codigo` int(11) NOT NULL,
  `instituicao` varchar(2000) DEFAULT NULL,
  `sigla` varchar(45) DEFAULT NULL,
  `endereco` varchar(2000) DEFAULT NULL,
  `municipio` varchar(500) DEFAULT NULL,
  `uf` char(2) DEFAULT NULL,
  `org_academica` varchar(45) DEFAULT NULL,
  `tipo_credenciamento` varchar(45) DEFAULT NULL,
  `categoria` varchar(45) DEFAULT NULL,
  `categoria_adm` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
