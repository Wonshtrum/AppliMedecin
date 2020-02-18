DROP DATABASE projetgi;
CREATE DATABASE projetgi;
USE projetgi;
CREATE TABLE user (
	id int(10) NOT NULL UNIQUE auto_increment,
	login varchar(30),
	password varchar(30),
	PRIMARY KEY(id)
);