CREATE DATABASE banco;-- ? Creamos la base de datos

USE banco; -- ? Utilizamos la base de datos.

CREATE TABLE `transferencia` (
  `id` INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `id_ordenante` INT(11),
  `id_beneficiario` INT(11),
  `importe` DOUBLE,
  `concepto` VARCHAR(40),
  `fecha` TIMESTAMP
);

CREATE TABLE `gestor` (
  `id` INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `usuario` CHAR(20),
  `password` CHAR(64),
  `correo` CHAR(50)
);

CREATE TABLE `prestamo_relacion` (
  `id_prestamo` INT(11),
  `id_cliente` INT(11)
);

CREATE TABLE `prestamo` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` CHAR(20),
  `comision` DOUBLE,
  `meses` INT(11),
  PRIMARY KEY (`id`)
  );

CREATE TABLE `cliente` (
  `id` INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `id_gestor` INT(11),
  `usuario` CHAR(20),
  `password` CHAR(64),
  `correo` CHAR(50),
  `saldo` DOUBLE
);

CREATE TABLE `mensaje` (
  `id` INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `id_origen` INT(11),
  `id_destino` INT(11),
  `texto` CHAR(140),
  `fecha` TIMESTAMP
);