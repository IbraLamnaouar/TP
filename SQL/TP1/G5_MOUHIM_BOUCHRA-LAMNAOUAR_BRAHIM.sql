/* I- Creation de la base de donnee */
CREATE DATABASE DB_FNM;

SHOW DATABASES;

USE DB_FNM;

/* II- Creation des tableaux */

CREATE TABLE Artiste (cdart INTEGER AUTO_INCREMENT, nom VARCHAR(30), sexe CHAR(1), datns VARCHAR(10), localite VARCHAR(25), pays VARCHAR(15), datdc Date, CONSTRAINT Check_Sexe CHECK(sexe = 'F' OR sexe = 'M'), PRIMARY KEY (cdart));

CREATE TABLE Oeuvre(cdevr INTEGER, titre VARCHAR(100) NOT NULL, datcr VARCHAR(10) NOT NULL, cdart INTEGER, cdsup ENUM('Toile', 'Papier', 'Carton', 'Bois', 'Cuivre'), cdacq ENUM('Don', 'Legs', 'Dation', 'Achat'), valeur FLOAT(20, 2), PRIMARY KEY (cdevr), CONSTRAINT Ref_Cdart FOREIGN KEY (cdart) REFERENCES Artiste(cdart), CONSTRAINT Check_Valeur CHECK(valuer >= 0));

CREATE TABLE Musee(cdmus CHAR(2) PRIMARY KEY, nom VARCHAR(100), region VARCHAR(25), ville VARCHAR(15));

CREATE TABLE Exposition(cdmus CHAR(2), cdevr INTEGER, Datedeb DATE, Datefin DATE, PRIMARY KEY (cdmus, cdevr), CONSTRAINT Ref_Cdmus FOREIGN KEY (cdmus) REFERENCES Musee(cdmus), CONSTRAINT Ref_Cdevr FOREIGN KEY (cdevr) REFERENCES Oeuvre(cdevr));

CREATE TABLE Technique(cdtcn CHAR(2) PRIMARY KEY, inttcn VARCHAR(25));

CREATE TABLE Realisation(cdevr INTEGER, cdtcn CHAR(2), PRIMARY KEY (cdtcn, cdevr), CONSTRAINT Ref_Cdtcn_Realiasion FOREIGN KEY (cdtcn) REFERENCES Technique(cdtcn), CONSTRAINT Ref_Cdevr_Realiasion FOREIGN KEY (cdevr) REFERENCES Oeuvre(cdevr));

CREATE TABLE Tendance(cdtdn CHAR(2) PRIMARY KEY, inttdn VARCHAR(25));

CREATE TABLE Expression(cdart INTEGER, cdtdn CHAR(2), PRIMARY KEY (cdart, cdtdn), CONSTRAINT Expression_Ref_Cdart FOREIGN KEY (cdart) REFERENCES Artiste(cdart), CONSTRAINT Expression_Ref_CdTdn FOREIGN KEY (cdtdn) REFERENCES Tendance(cdtdn));

/* Pour afficher la liste des tables "SHOW TABLES" */
SHOW TABLES;


/* Pour afficher les colonnes d'une table "DESCRIBE" */
DESCRIBE Artiste;

/* III- */

/* Artiste */
INSERT INTO Artiste(nom, sexe, datns, localite, pays, datdc) VALUES("Pablo Picasso", "M", "1881", "Malaga", "Spain", '1973/04/08');
INSERT INTO Artiste(nom, sexe, datns, localite, pays, datdc) VALUES("Jackson Pollock", "M", "1912", "Wyoming", "USA", '1956/08/11');
INSERT INTO Artiste(nom, sexe, datns, localite, pays, datdc) VALUES("Claude Monet", "M", "1840", "Paris", "France", '1926/12/05');
INSERT INTO Artiste(nom, sexe, datns, localite, pays, datdc) VALUES("Vincent van Gogh", "M", "1853", "Zundert", "Netherlands", '1890/07/29');
INSERT INTO Artiste(nom, sexe, datns, localite, pays, datdc) VALUES("Frida Kahlo", "F", "1907", "Mexico City", "Mexico", '1954/07/13');
INSERT INTO Artiste(nom, sexe, datns, localite, pays, datdc) VALUES("Mary Cassatt", "F", "1844", "Allegheny", "USA", '1926/06/14');
INSERT INTO Artiste(nom, sexe, datns, localite, pays, datdc) VALUES("Salvador Dal", "M", "1904", "Figueres", "Spain", '1989/01/23');
INSERT INTO Artiste(nom, sexe, datns, localite, pays) VALUES("Bridget Riley", "F", "1931", "London", "UK");
INSERT INTO Artiste(nom, sexe, datns, pays, datdc) VALUES("Augusto Rivera", "M", "1922", "Columbia", '1982/08/18');
INSERT INTO Artiste(nom, sexe, datns, localite, pays, datdc) VALUES("Ida O\'Keeffe","F", "1889", "Wisconsin", "USA", '1961/09/27');

/* Oeuvre */
INSERT INTO Oeuvre(cdevr, titre, cdart, datcr, cdsup, cdacq, valeur) VALUES(1, "The Tragedy",( SELECT cdart FROM Artiste WHERE nom="Pablo Picasso"), "1778", "Toile", "Don", 155000000);
INSERT INTO Oeuvre(cdevr, titre, cdart, datcr, cdsup, cdacq, valeur) VALUES(2, "Life", ( SELECT cdart FROM Artiste WHERE nom="Pablo Picasso"), "1776", "Toile", "Legs", 10000000);
INSERT INTO Oeuvre(cdevr, titre, cdart, datcr, cdsup, cdacq, valeur) VALUES(3, "Rocks at Port Coton, the Lion Rock", ( SELECT cdart FROM Artiste WHERE nom="Claude Monet"), "1886", "Toile", "Achat", 120000000);
INSERT INTO Oeuvre(cdevr, titre, cdart, datcr, cdsup, cdacq, valeur) VALUES(4, "Flower of Life (Flame Flower)", ( SELECT cdart FROM Artiste WHERE nom="Frida Kahlo"), "1943", "Papier", "Achat", 90000000);
INSERT INTO Oeuvre(cdevr, titre, cdart, datcr, cdsup, cdacq, valeur) VALUES(5, "Weeping Coconuts or Coconut Tears", ( SELECT cdart FROM Artiste WHERE nom="Frida Kahlo"), "1951", "Toile", "Dation", 125000000);
INSERT INTO Oeuvre(cdevr, titre, cdart, datcr, cdsup, cdacq, valeur) VALUES(6, "The Sea at Fecamp", ( SELECT cdart FROM Artiste WHERE nom="Claude Monet"), "1881", "Toile", "Don", 125000000.00);

/* Musee Mohammed VI d'art moderne et contemporain */
INSERT INTO Musee(cdmus, nom, region, ville) VALUES(1, "Musee Mohammed VI d'art moderne et contemporain", "Rabat-Salé-Kénitra", "Rabat");
INSERT INTO Musee(cdmus, nom, region, ville) VALUES(2, "Villa des arts de Rabat", "Rabat-Salé-Kénitra", "Rabat");

/* Exposition */
INSERT INTO Exposition(cdmus, cdevr, Datedeb, Datefin) VALUES(1, (SELECT cdevr FROM Oeuvre WHERE titre LIKE "%Flower of Life%"), '2020-02-19', '2020-02-26');
INSERT INTO Exposition(cdmus, cdevr, Datedeb, Datefin) VALUES(1, (SELECT cdevr FROM Oeuvre WHERE titre LIKE "%Lion Rock%"), '2020-02-29', '2020-03-05');
INSERT INTO Exposition(cdmus, cdevr, Datedeb, Datefin) VALUES(1, (SELECT cdevr FROM Oeuvre WHERE titre LIKE "%Coconut Tears%"), '2020-02-19', '2020-02-26');
INSERT INTO Exposition(cdmus, cdevr, Datedeb, Datefin) VALUES(2, (SELECT cdevr FROM Oeuvre WHERE titre LIKE "%Flower of Life%"), '2020-02-29', '2020-03-05');
INSERT INTO Exposition(cdmus, cdevr, Datedeb, Datefin) VALUES(2, (SELECT cdevr FROM Oeuvre WHERE titre LIKE "%Lion Rock%"), '2020-02-19', '2020-02-26');
INSERT INTO Exposition(cdmus, cdevr, Datedeb, Datefin) VALUES(2, (SELECT cdevr FROM Oeuvre WHERE titre LIKE "%Coconut Tears%"), '2020-02-29', '2020-03-05');
INSERT INTO Exposition(cdmus, cdevr, Datedeb, Datefin) VALUES(1, (SELECT cdevr FROM Oeuvre WHERE titre LIKE "%Tragedy%"), '2020-02-29', '2020-03-05');
INSERT INTO Exposition(cdmus, cdevr, Datedeb, Datefin) VALUES(2, (SELECT cdevr FROM Oeuvre WHERE titre LIKE "%Tragedy%"), '2020-02-19', '2020-02-26');

/* Technique */
INSERT INTO Technique(cdtcn, inttcn) VALUES (1, "acrylique");
INSERT INTO Technique(cdtcn, inttcn) VALUES (2, "aquarelle");

/* Realisation */
INSERT INTO Realisation(cdevr, cdtcn) VALUES(1, 2);
INSERT INTO Realisation(cdevr, cdtcn) VALUES(2, 1);
INSERT INTO Realisation(cdevr, cdtcn) VALUES(3, 2);
INSERT INTO Realisation(cdevr, cdtcn) VALUES(4, 1);
INSERT INTO Realisation(cdevr, cdtcn) VALUES(5, 2);
INSERT INTO Realisation(cdevr, cdtcn) VALUES(6, 2);

/* Tendance */
INSERT INTO Tendance(cdtdn, inttdn) VALUES (1, "symbolisme");
INSERT INTO Tendance(cdtdn, inttdn) VALUES (2, "surrealisme");
INSERT INTO Tendance(cdtdn, inttdn) VALUES (3, "Impressionnisme");

/* Expression */
INSERT INTO Expression(cdart, cdtdn) VALUES(( SELECT cdart FROM Artiste WHERE nom="Pablo Picasso"), 1);
INSERT INTO Expression(cdart, cdtdn) VALUES(( SELECT cdart FROM Artiste WHERE nom="Frida Kahlo"), 2);
INSERT INTO Expression(cdart, cdtdn) VALUES(( SELECT cdart FROM Artiste WHERE nom="Claude Monet"), 3);

/* Show data*/
SELECT * FROM Artiste;
SELECT * FROM Oeuvre;
SELECT * FROM Musee;
SELECT * FROM Exposition;
SELECT * FROM Technique;
SELECT * FROM Realisation;
SELECT * FROM Tendance;
SELECT * FROM Expression;

/**
 * TP2
 */


/**
 * Ajout, Mise-à-jour et selection des données
 */
INSERT INTO Artiste(nom, sexe, datns, localite, pays) VALUES("Monir Farmanfarmaian", "M", "1922", "Tehran", "Iran");

/* INSERT THEN UPDATE*/
INSERT INTO Oeuvre(cdevr, titre, cdart, datcr, cdsup, cdacq) VALUES(7, "Stars",( SELECT cdart FROM Artiste WHERE nom="Monir Farmanfarmaian"), "2005", "Toile", "Don");
UPDATE Oeuvre SET valeur=60000 WHERE cdevr = 7;

/* INSERT TENDANCE */
/* 'Tendance' doesn't have anything to do with the artist. So it's not gonna pose any problems*/
INSERT INTO Tendance(cdtdn, inttdn) VALUES (4, "Nouvelle Tendance");

/* 7- Unknown Artiste */
/* We could create a new artist under the name "Unknown" */
INSERT INTO Artiste(nom, sexe, datns, localite, pays) VALUES("Unknown", "M", "DC", "Everywhere", "Everywhere");
INSERT INTO Oeuvre(cdevr, titre, cdart, datcr, cdsup, cdacq) VALUES(8, "Portrait of an Unknown First World War Officer",( SELECT cdart FROM Artiste WHERE nom="Unknown"), "1910", "Papier", "Don");

