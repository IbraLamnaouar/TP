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

INSERT INTO Artiste(nom, sexe, datns, localite, pays, datdc) 	VALUES("Pablo Picasso", "M", "1881", "Malaga", "Spain", "08/04/1973");
INSERT INTO Artiste(nom, sexe, datns, localite, pays, datdc) 	VALUES("Jackson Pollock", "M", "1912", "Wyoming", "USA", "11/08/1956");
INSERT INTO Artiste(nom, sexe, datns, localite, pays, datdc) 	VALUES("Claude Monet", "M", "1840", "Paris", "France", "05/12/1926");
INSERT INTO Artiste(nom, sexe, datns, localite, pays, datdc) 	VALUES("Vincent van Gogh", "M", "1853", "Zundert", "Netherlands", "29/07/1890");
INSERT INTO Artiste(nom, sexe, datns, localite, pays, datdc) 	VALUES("Frida Kahlo", "F", "1907", "Mexico City", "Mexico", "13/07/1954");
INSERT INTO Artiste(nom, sexe, datns, localite, pays, datdc) 	VALUES("Mary Cassatt", "F", "1844", "Allegheny", "USA", "14/06/1926");
INSERT INTO Artiste(nom, sexe, datns, localite, pays, datdc) 	VALUES("Salvador Dal", "M", "1904", "Figueres", "Spain", "23/01/1989");
INSERT INTO Artiste(nom, sexe, datns, localite, pays) 			VALUES("Bridget Riley", "F", "1931", "London", "UK");
INSERT INTO Artiste(nom, sexe, datns, 			pays, datdc) 	VALUES("Augusto Rivera", "M", "1922", "Columbia", "18/08/1982");
INSERT INTO Artiste(nom, sexe, datns, localite, pays, datdc) 	VALUES("Ida O\'Keeffe","F", "1889", "Wisconsin", "USA", "27/09/1961");
