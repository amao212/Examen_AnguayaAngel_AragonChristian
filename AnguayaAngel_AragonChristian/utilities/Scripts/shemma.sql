.version
.database
.show
.tables


DROP TABLE AA_DIAS;


CREATE TABLE AA_DIAS
(
    IdDias          INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT,
    Dias            VARCHAR(45) NOT NULL,
    Estado          VARCHAR(5)  NOT NULL
);

INSERT INTO AA_DIAS (Dias, Estado) VALUES ("Lunes","A");
INSERT INTO AA_DIAS (Dias, Estado) VALUES ("Martes","A");
INSERT INTO AA_DIAS (Dias, Estado) VALUES ("Miercoles","A");
INSERT INTO AA_DIAS (Dias, Estado) VALUES ("Jueves","A");
INSERT INTO AA_DIAS (Dias, Estado) VALUES ("Vierenes","A");


CREATE TABLE AA_TIPO_ARSENAL
(
    IdTipoArsenal          INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT,
    TipoArsenal            VARCHAR(45) NOT NULL,
    Estado                 VARCHAR(5)  NOT NULL
);
INSERT INTO AA_TIPO_ARSENAL (TipoArsenal, Estado) VALUES ("Maritimo","A");
INSERT INTO AA_TIPO_ARSENAL (TipoArsenal, Estado) VALUES ("Terrestre","A");
INSERT INTO AA_TIPO_ARSENAL (TipoArsenal, Estado) VALUES ("Aereo","A");




CREATE TABLE AA_HORA
(
    IdHora          INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT,
    Hora            VARCHAR(45) NOT NULL,
    Estado          VARCHAR(5)  NOT NULL
);
INSERT INTO AA_HORA (Hora, Estado) VALUES ("01-02","A");
INSERT INTO AA_HORA (Hora, Estado) VALUES ("02-04","A");
INSERT INTO AA_HORA (Hora, Estado) VALUES ("03-06","A");
INSERT INTO AA_HORA (Hora, Estado) VALUES ("04-08","A");
INSERT INTO AA_HORA (Hora, Estado) VALUES ("05-10","A");


CREATE TABLE AA_ARSENAL
(
    IdArsenal          INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT,
    Arsenal            VARCHAR(45) NOT NULL,
    Estado             VARCHAR(5)  NOT NULL
);


INSERT INTO AA_ARSENAL (Arsenal, Estado) VALUES ("Avion","A");
INSERT INTO AA_ARSENAL (Arsenal, Estado) VALUES ("Avion, BArco","A");
INSERT INTO AA_ARSENAL (Arsenal, Estado) VALUES ("Avion, Barco, Convoy","A");
INSERT INTO AA_ARSENAL (Arsenal, Estado) VALUES ("Avion, Barco, Convoy, Dron","A");
INSERT INTO AA_ARSENAL (Arsenal, Estado) VALUES ("Avion, Barco, Convoy, Dron, Tanque","A");

CREATE TABLE AA_COORDENADAS
(   IdCoordenadas       INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT,
    Coordenadas         VARCHAR(45) NOT NULL,
    Estado              VARCHAR(5)  NOT NULL
);

INSERT INTO AA_COORDENADAS (Coordenadas, Estado) VALUES ('01-Coord_North',"A");
INSERT INTO AA_COORDENADAS (Coordenadas, Estado) VALUES ('02-Coord_Easth',"A");
INSERT INTO AA_COORDENADAS (Coordenadas, Estado) VALUES ('03-Coord_North',"A");
INSERT INTO AA_COORDENADAS (Coordenadas, Estado) VALUES ('04-Coord_East' ,"A");
INSERT INTO AA_COORDENADAS (Coordenadas, Estado) VALUES ('05-Coord_North',"A");
INSERT INTO AA_COORDENADAS (Coordenadas, Estado) VALUES ('06-Coord_East' ,"A");
INSERT INTO AA_COORDENADAS (Coordenadas, Estado) VALUES ('07-Coord_North',"A");
INSERT INTO AA_COORDENADAS (Coordenadas, Estado) VALUES ('08-Coord_East' ,"A");
INSERT INTO AA_COORDENADAS (Coordenadas, Estado) VALUES ('09-Coord_North',"A");
INSERT INTO AA_COORDENADAS (Coordenadas, Estado) VALUES ('00-Coord_South',"A");

CREATE TABLE AA_COORDENADAS_UCRANIANAS
(
    IdCoordenada        INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT,
    IdTipoArsenal       INTEGER     NULL,
    IdCoordenadas       INTEGER     NULL,
    IdArsenal           INTEGER     NULL,
    IdDias              INTEGER     NULL,
    IdHora              INTEGER     NULL,


    CONSTRAINT fk_IdDias,       FOREIGN KEY (IdDias) REFERENCES AA_DIAS (IdDias),
    CONSTRAINT fk_IdTipoArsenal,FOREIGN KEY (IdTipoArsenal) REFERENCES AA_TIPO_ARSENAL(IdTipoArsenal),
    CONSTRAINT fk_IdArsenal,    FOREIGN KEY (IdArsenal) REFERENCES AA_HORA(IdHora),
    CONSTRAINT fk_IdHora,       FOREIGN KEY (IdHora) REFERENCES AA_ARSENAL(IdArsenal),
    CONSTRAINT fk_IdCoordenadas,       FOREIGN KEY (IdCoordenadas) REFERENCES AA_COORDENADAS(IdCoordenadas)
);



INSERT INTO AA_COORDENADAS_UCRANIANAS (IdTipoArsenal,IdCoordenadas,IdArsenal,IdDias,IdHora) VALUES (1,1,1,1,1);
INSERT INTO AA_COORDENADAS_UCRANIANAS (IdTipoArsenal,IdCoordenadas,IdArsenal,IdDias,IdHora) VALUES (1,9,2,1,1);
INSERT INTO AA_COORDENADAS_UCRANIANAS (IdTipoArsenal,IdCoordenadas,IdArsenal,IdDias,IdHora) VALUES (1,4,4,4,4);
INSERT INTO AA_COORDENADAS_UCRANIANAS (IdTipoArsenal,IdCoordenadas,IdArsenal,IdDias,IdHora) VALUES (1,0,1,null,null);
INSERT INTO AA_COORDENADAS_UCRANIANAS (IdTipoArsenal,IdCoordenadas,IdArsenal,IdDias,IdHora) VALUES (1,6,5,4,4);
INSERT INTO AA_COORDENADAS_UCRANIANAS (IdTipoArsenal,IdCoordenadas,IdArsenal,IdDias,IdHora) VALUES (1,0,1,null,null);
INSERT INTO AA_COORDENADAS_UCRANIANAS (IdTipoArsenal,IdCoordenadas,IdArsenal,IdDias,IdHora) VALUES (1,7,4,3,3);
INSERT INTO AA_COORDENADAS_UCRANIANAS (IdTipoArsenal,IdCoordenadas,IdArsenal,IdDias,IdHora) VALUES (1,2,2,2,2);
INSERT INTO AA_COORDENADAS_UCRANIANAS (IdTipoArsenal,IdCoordenadas,IdArsenal,IdDias,IdHora) VALUES (1,7,4,3,3);
INSERT INTO AA_COORDENADAS_UCRANIANAS (IdTipoArsenal,IdCoordenadas,IdArsenal,IdDias,IdHora) VALUES (1,1,1,1,1);



SELECT c.TipoArsenal, f.Coordenadas, d.Arsenal, b.Dias, e.Hora
FROM AA_COORDENADAS_UCRANIANAS a
JOIN AA_TIPO_ARSENAL c ON a.IdTipoArsenal = c.IdTipoArsenal
JOIN AA_COORDENADAS f ON a.IdCoordenadas = f.IdCoordenadas
JOIN AA_ARSENAL d ON a.IdArsenal = d.IdArsenal
JOIN AA_DIAS b ON a.IdDias = b.IdDias
JOIN AA_HORA e ON a.IdHora = e.IdHora



SELECT  a.IdAnimales,b.Coord_, c.FormaNacer  ,NombreAnimal, EstadoAnimal, FechaIngreso, FechaModificado
FROM ANIMALES a
JOIN AA_DIAS c ON a.IdFormaNacer = c.IdFormaNacer
JOIN AA_GEO_POSICION b ON a.IdNP = b.IdNP