CREATE TABLE Clothes (
    id       INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name     NVARCHAR,
    producer NVARCHAR,
    price    FLOAT,
    mem      NVARCHAR,
    material NVARCHAR,
    size     NVARCHAR
);

CREATE TABLE Cutlery (
    id       INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name     NVARCHAR,
    producer NVARCHAR,
    price    FLOAT,
    mem      NVARCHAR,
    material NVARCHAR,
    volume   NVARCHAR
);

CREATE TABLE Trifle (
    id       INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name     NVARCHAR,
    producer NVARCHAR,
    price    FLOAT,
    mem      NVARCHAR,
    material NVARCHAR,
    amount   INT
);

CREATE TABLE User (
    id       INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    login    NVARCHAR           NOT NULL UNIQUE,
    password NVARCHAR           NOT NULL
);