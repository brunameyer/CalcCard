create database Calccard;

CREATE TABLE `calccard`.`bandeira` (
  `idBandeira` INT NOT NULL AUTO_INCREMENT,
  `Descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idBandeira`));

INSERT INTO `calccard`.`bandeira` (`Descricao`) VALUES ('Mastercard');
INSERT INTO `calccard`.`bandeira` (`Descricao`) VALUES ('Visa');
INSERT INTO `calccard`.`bandeira` (`Descricao`) VALUES ('Diners');
