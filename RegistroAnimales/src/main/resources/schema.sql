CREATE TABLE IF NOT EXISTS Animals (

id identity primary key,
identification int(15) NOT NULL,
name VARCHAR(30) NOT NULL,
race VARCHAR(50) NOT NULL,
weight float(3,2) NOT NULL,
vaccines VARCHAR(1000) NOT NULL,
description VARCHAR(300) NOT NULL,
birthday DATE NOT NULL


);

CREATE TABLE IF NOT EXISTS Owners (

id identity primary key,
fullname VARCHAR(50) NOT NULL,
identification VARCHAR(9) NOT NULL,
address VARCHAR(100) NOT NULL,
phone int(12) NOT NULL,
birthday DATE NOT NULL

);

CREATE TABLE IF NOT EXISTS AnimalsOwners (

id identity primary key,
id_owner int NOT NULL,
id_animal int NOT NULL,
FOREIGN KEY (id_owner) REFERENCES Owners(id),
FOREIGN KEY (id_animal) REFERENCES Animals(id)

);