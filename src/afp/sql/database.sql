-- drop database
DROP DATABASE assistentefinanceiropessoal;

-- create database
CREATE DATABASE IF NOT EXISTS assistentefinanceiropessoal;
USE assistentefinanceiropessoal;

-- create tables
CREATE TABLE IF NOT EXISTS categorias(
    id INT AUTO_INCREMENT,
    titulo VARCHAR(16) NOT NULL UNIQUE,
    descricao VARCHAR(140),
    PRIMARY KEY(id)
);


CREATE TABLE IF NOT EXISTS contas(
    id INT AUTO_INCREMENT,
    titulo VARCHAR(25) NOT NULL,
    descricao VARCHAR(140),
    cat_id INT NOT NULL,
    tipo VARCHAR(7) NOT NULL,
    valor LONG NOT NULL,
    dt_criacao DATE NOT NULL,
    dt_vencimento DATE NOT NULL,
    quitado BOOL NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (cat_id) REFERENCES categorias(id)
);
