CREATE TABLE uzytkownik (
         id_uzytkownik INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
         nick VARCHAR(20),
         haslo VARCHAR(20),
         email VARCHAR(30)
);

CREATE TABLE ocena (
         id_ocena INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
         przepis_id INT FOREIGN KEY REFERENCES przepis(id_przepis),
         uzytkownik_id INT FOREIGN KEY REFERENCES uzytkownik(id_uzytkownik),
         ocena INT,
         komentarz VARCHAR(100)
);

CREATE TABLE przepis (
         id_przepis INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
         nazwa VARCHAR(20),
         tresc VARCHAR(200),
         zdjecie VARCHAR(50),
         sredniaocena INT
);

CREATE TABLE skladnik_has_przepis (
         przepis_id INT FOREIGN KEY REFERENCES przepis(id_przepis),
         skladnik_id INT FOREIGN KEY REFERENCES skladnik(id_skladnik)
);

CREATE TABLE skladnik (
         id_skladnik INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
         nazwa VARCHAR(20)
);
