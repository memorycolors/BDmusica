drop table MUSICA;
DROP TABLE CANCION;
DROP TABLE ALBUM;
DROP TABLE GENERO;
CREATE TABLE GENERO (
    ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
    CODIGO CHAR(2),
    NOMBRE VARCHAR(20) NOT NULL,
    CONSTRAINT ID_GENERO_PK PRIMARY KEY (ID)
);
    
CREATE TABLE ALBUM (
    ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
    NUMERO_CANCIONES SMALLINT,
    NOMBRE VARCHAR(20) NOT NULL,
    CONSTRAINT ID_ALBUM_PK PRIMARY KEY (ID)
);

CREATE TABLE CANCION (
    ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY, -- Id autonumérico
    TITULO VARCHAR(40),
    ALBUM INTEGER NOT NULL,
    CANTANTE VARCHAR(30),
    GENERO INTEGER NOT NULL,
    FECHA_LANZAMIENTO DATE,
    PRECIO DECIMAL(7,2),
    FAVORITO BOOLEAN,
    FOTO VARCHAR(30),
    CONSTRAINT ID_CANCION_PK PRIMARY KEY (ID),
    CONSTRAINT GEN_CANCION_FK FOREIGN KEY (GENERO) REFERENCES GENERO (ID),
    CONSTRAINT AL_CANCION_FK FOREIGN KEY (ALBUM) REFERENCES ALBUM (ID)
);


