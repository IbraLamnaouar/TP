
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

