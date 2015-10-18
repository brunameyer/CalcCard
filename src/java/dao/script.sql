create database Calccard;

CREATE TABLE `calccard`.`bandeira` (
  `idBandeira` INT NOT NULL AUTO_INCREMENT,
  `Descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idBandeira`));

CREATE TABLE `calccard`.`cartao` (
  `idCartao` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `taxaCredito` FLOAT NOT NULL COMMENT '',
  `taxaDebito` FLOAT NOT NULL COMMENT '',
  PRIMARY KEY (`idCartao`)  COMMENT '');


INSERT INTO `calccard`.`bandeira` (`Descricao`) VALUES ('Mastercard');
INSERT INTO `calccard`.`bandeira` (`Descricao`) VALUES ('Visa');
INSERT INTO `calccard`.`bandeira` (`Descricao`) VALUES ('Diners');

INSERT INTO `calccard`.`cartao` (`taxaCredito`, `taxaDebito`) VALUES ('2.20', '1.80');