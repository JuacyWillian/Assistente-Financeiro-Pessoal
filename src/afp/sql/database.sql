/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  jw
 * Created: 08/05/2016
 */

create database assistentefinanceiropessoal;
use assistentefinanceiropessoal;

create table categorias(
    id int auto_increment,
    titulo varchar(16) not null,
    descricao varchar(140),
    primary key(id)
);


create table contas(
    id int auto_increment,
    titulo varchar(25) not null,
    descricao varchar(140),
    cat_id int not null,
    tipo varchar(7) not null,
    valor float not null,
    dt_criacao date not null,
    dt_vencimento date not null,
    quitado bool not null,
    primary key(id),
    foreign key (cat_id) references categorias(id)
);
