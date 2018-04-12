DROP DATABASE IF EXISTS provajava;
CREATE DATABASE IF NOT EXISTS provajava;
USE provajava;

CREATE TABLE Assalariados(
    pk_idAssalariado INT PRIMARY KEY AUTO_INCREMENT,
 	nome VARCHAR(50),
    sobrenome VARCHAR(50),
    cpf VARCHAR(11),
    salario DOUBLE
);

CREATE TABLE Comissionados( 
    pk_idComissionados INT PRIMARY KEY AUTO_INCREMENT,
 	nome VARCHAR(50),
    sobrenome VARCHAR(50),
    cpf VARCHAR(11),
    totalVenda DOUBLE,
    taxaComissao DOUBLE
);

CREATE TABLE Horistas(
    pk_idHoristas INT PRIMARY KEY AUTO_INCREMENT,
 	nome VARCHAR(50),
    sobrenome VARCHAR(50),
    cpf VARCHAR(11),
    precoHora DOUBLE,
    horasTrabalhadas DOUBLE
);