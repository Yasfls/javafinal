CREATE SCHEMA IF NOT EXISTS `evento`;
USE `evento`;

CREATE TABLE IF NOT EXISTS `evento`.`organizador` (
  `id_org` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nome_org` VARCHAR(50) NOT NULL,
  `email_org` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id_org`));

CREATE TABLE IF NOT EXISTS `evento`.`participante` (
  `id_part` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nome_part` VARCHAR(50) NOT NULL,
  `tel_part` VARCHAR (50) NOT NULL,
  PRIMARY KEY (`id_part`));

CREATE TABLE IF NOT EXISTS `evento`.`local` (
  `id_local` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `desc_local` VARCHAR(50) NOT NULL,
  `vagas_local` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_local`));

CREATE TABLE IF NOT EXISTS `evento`.`evento` (
  `id_evento` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_org` INT UNSIGNED NOT NULL,
  CONSTRAINT fk_idorg FOREIGN KEY (id_org) REFERENCES organizador (id_org),
  `id_local` INT UNSIGNED NOT NULL,
  CONSTRAINT fk_idlocal FOREIGN KEY (id_local) REFERENCES local (id_local),
  `vagas_evento` INT UNSIGNED NOT NULL,
  `data_evento` VARCHAR(10) NOT NULL,
  `desc_evento` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id_evento`);
  )