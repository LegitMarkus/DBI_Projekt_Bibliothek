-- Generiert von Oracle SQL Developer Data Modeler 20.2.0.167.1538
--   am/um:        2022-03-15 08:49:03 MEZ
--   Site:      Oracle Database 11g
--   Typ:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE arbeitsort (
                            id    NUMBER NOT NULL,
                            name  VARCHAR2
--  ERROR: VARCHAR2 size not specified
                                         NOT NULL
);

ALTER TABLE arbeitsort ADD CONSTRAINT arbeitsort_pk PRIMARY KEY ( id );

CREATE TABLE audit_trail (
                             id             NUMBER NOT NULL,
                             datetime       VARCHAR2
--  ERROR: VARCHAR2 size not specified
    ,
                             isuser         CHAR(1),
                             "table"        VARCHAR2
--  ERROR: VARCHAR2 size not specified
    ,
                             changedcolumn  VARCHAR2
--  ERROR: VARCHAR2 size not specified
    ,
                             old_value      VARCHAR2
--  ERROR: VARCHAR2 size not specified
    ,
                             new_value      VARCHAR2
--  ERROR: VARCHAR2 size not specified

);

ALTER TABLE audit_trail ADD CONSTRAINT audit_trail_pk PRIMARY KEY ( id );

CREATE TABLE ausleihung (
                            id                                NUMBER NOT NULL,
                            ausleihdatum                      DATE,
--  ERROR: Column name length exceeds maximum allowed length(30)
                            rueckgabedatum  DATE,
                            verlaengerungsanzahl              NUMBER NOT NULL,
                            kunde_id                          NUMBER NOT NULL,
                            medien_id                         NUMBER NOT NULL
);

ALTER TABLE ausleihung ADD CONSTRAINT ausleihung_pk PRIMARY KEY ( id );

CREATE TABLE autor (
                       id        NUMBER NOT NULL,
                       vorname   VARCHAR2
--  ERROR: VARCHAR2 size not specified
    ,
                       nachname  VARCHAR2
--  ERROR: VARCHAR2 size not specified

);

ALTER TABLE autor ADD CONSTRAINT autor_pk PRIMARY KEY ( id );

CREATE TABLE buch (
    id NUMBER NOT NULL
);

CREATE UNIQUE INDEX buch__idx ON
    buch (
          id
          ASC );

ALTER TABLE buch ADD CONSTRAINT buch_pk PRIMARY KEY ( id );

CREATE TABLE buch_author (
                             autor_id  NUMBER NOT NULL,
                             buch_id   NUMBER NOT NULL
);

ALTER TABLE buch_author ADD CONSTRAINT buch_author_pk PRIMARY KEY ( autor_id,
                                                                    buch_id );

CREATE TABLE digitale_medien (
    id NUMBER NOT NULL
);

CREATE UNIQUE INDEX digitale_medien__idx ON
    digitale_medien (
                     id
                     ASC );

ALTER TABLE digitale_medien ADD CONSTRAINT digitale_medien_pk PRIMARY KEY ( id );

ALTER TABLE digitale_medien ADD CONSTRAINT digitale_medien_medien_id_un UNIQUE ( id );

CREATE TABLE digitalemedien_author (
                                       autor_id           NUMBER NOT NULL,
                                       digitalemedien_id  NUMBER NOT NULL
);

ALTER TABLE digitalemedien_author ADD CONSTRAINT digitalemedien_author_pk PRIMARY KEY ( autor_id,
                                                                                        digitalemedien_id );

CREATE TABLE "E-Book" (
    id NUMBER NOT NULL
);

CREATE UNIQUE INDEX "E-Book__IDX" ON
    "E-Book" (
              id
              ASC );

CREATE UNIQUE INDEX "E-Book__IDXv1" ON
    "E-Book" (
              id
              ASC );

ALTER TABLE "E-Book" ADD CONSTRAINT "E-Book_PK" PRIMARY KEY ( id );

CREATE TABLE genre (
                       id                         NUMBER NOT NULL,
                       genre                      VARCHAR2(50) NOT NULL,
                       digitale_medien_medien_id  NUMBER NOT NULL
);

ALTER TABLE genre ADD CONSTRAINT genre_pk PRIMARY KEY ( id );

CREATE TABLE hörbuch (
    id NUMBER NOT NULL
);

CREATE UNIQUE INDEX hörbuch__idx ON
    hörbuch (
             id
             ASC );

CREATE UNIQUE INDEX hörbuch__idxv1 ON
    hörbuch (
             id
             ASC );

ALTER TABLE hörbuch ADD CONSTRAINT hörbuch_pk PRIMARY KEY ( id );

CREATE TABLE hörbuch_sprecher (
                                  vorleser_vorleser_id  NUMBER NOT NULL,
                                  hörbuch_id            NUMBER NOT NULL
);

ALTER TABLE hörbuch_sprecher ADD CONSTRAINT hörbuch_sprecher_pk PRIMARY KEY ( vorleser_vorleser_id,
                                                                              hörbuch_id );

CREATE TABLE kunde (
                       id            NUMBER NOT NULL,
                       kundennummer  VARCHAR2(50),
                       vorname       VARCHAR2
--  ERROR: VARCHAR2 size not specified
    ,
                       nachname      VARCHAR2
--  ERROR: VARCHAR2 size not specified

);

ALTER TABLE kunde ADD CONSTRAINT kunde_pk PRIMARY KEY ( id );

CREATE TABLE medien (
                        id                       NUMBER NOT NULL,
                        titel                    VARCHAR2(50),
                        veroeffentlichungsdatum  DATE,
                        kaufdatum                DATE,
                        verlag_id                NUMBER NOT NULL,
                        uebersetzung             CHAR(1) NOT NULL,
                        sprache_id               NUMBER NOT NULL
);

ALTER TABLE medien ADD CONSTRAINT medien_pk PRIMARY KEY ( id );

CREATE TABLE medien_topic (
                              topic_id   NUMBER NOT NULL,
                              medien_id  NUMBER NOT NULL
);

ALTER TABLE medien_topic ADD CONSTRAINT medien_topic_pk PRIMARY KEY ( topic_id,
                                                                      medien_id );

CREATE TABLE personal (
                          id             NUMBER NOT NULL,
                          vorname        VARCHAR2(50),
                          nachname       VARCHAR2(50),
                          "Alter"        INTEGER,
                          email          VARCHAR2(50) NOT NULL,
                          arbeitsort_id  NUMBER NOT NULL,
                          gehalt         INTEGER,
                          kunde_id       NUMBER NOT NULL
);

CREATE UNIQUE INDEX personal__idx ON
    personal (
              kunde_id
              ASC );

ALTER TABLE personal ADD CONSTRAINT personal_pk PRIMARY KEY ( id );

CREATE TABLE physische_medien (
                                  id                           NUMBER NOT NULL,
                                  gesammtanzahl                NUMBER,
                                  verleih                      NUMBER,
                                  freihandbereich              NUMBER,
                                  mitarbeiterverkaufsfreigabe  CHAR(1) NOT NULL
);

ALTER TABLE physische_medien ADD CONSTRAINT physische_medien_pk PRIMARY KEY ( id );

CREATE TABLE rechnung (
                          id         NUMBER NOT NULL,
                          preis      NUMBER NOT NULL,
                          medien_id  NUMBER NOT NULL,
                          kunde_id   NUMBER NOT NULL
);

CREATE UNIQUE INDEX verkauf__idx ON
    rechnung (
              medien_id
              ASC );

ALTER TABLE rechnung ADD CONSTRAINT rechnung_pk PRIMARY KEY ( id );

CREATE TABLE reservierung (
                              kunde_id            NUMBER NOT NULL,
                              medien_id           NUMBER NOT NULL,
                              reservierungsdatum  DATE
);

ALTER TABLE reservierung ADD CONSTRAINT reservierung_pk PRIMARY KEY ( kunde_id,
                                                                      medien_id );

CREATE TABLE sprache (
                         id    NUMBER NOT NULL,
                         name  VARCHAR2
--  ERROR: VARCHAR2 size not specified
    ,
                         iso   VARCHAR2
--  ERROR: VARCHAR2 size not specified

);

ALTER TABLE sprache ADD CONSTRAINT sprache_pk PRIMARY KEY ( id );

CREATE TABLE sprecher (
    vorleser_id NUMBER NOT NULL
);

ALTER TABLE sprecher ADD CONSTRAINT sprecher_pk PRIMARY KEY ( vorleser_id );

CREATE TABLE topic (
                       id     NUMBER NOT NULL,
                       topic  VARCHAR2(50) NOT NULL
);

ALTER TABLE topic ADD CONSTRAINT topic_pk PRIMARY KEY ( id );

CREATE TABLE verlag (
                        id    NUMBER NOT NULL,
                        name  VARCHAR2(50)
);

ALTER TABLE verlag ADD CONSTRAINT verlag_pk PRIMARY KEY ( id );

CREATE TABLE zeitschrift (
    id NUMBER NOT NULL
);

CREATE UNIQUE INDEX zeitschrift__idx ON
    zeitschrift (
                 id
                 ASC );

ALTER TABLE zeitschrift ADD CONSTRAINT zeitschrift_pk PRIMARY KEY ( id );

CREATE TABLE zeitung (
    id NUMBER NOT NULL
);

CREATE UNIQUE INDEX zeitung__idx ON
    zeitung (
             id
             ASC );

ALTER TABLE zeitung ADD CONSTRAINT zeitung_pk PRIMARY KEY ( id );

ALTER TABLE buch_author
    ADD CONSTRAINT buch_author_autor_fk FOREIGN KEY ( autor_id )
        REFERENCES autor ( id );

ALTER TABLE buch_author
    ADD CONSTRAINT buch_author_buch_fk FOREIGN KEY ( buch_id )
        REFERENCES buch ( id );

ALTER TABLE buch
    ADD CONSTRAINT buch_physische_medien_fk FOREIGN KEY ( id )
        REFERENCES physische_medien ( id );

ALTER TABLE digitale_medien
    ADD CONSTRAINT digitale_medien_medien_fk FOREIGN KEY ( id )
        REFERENCES medien ( id );

ALTER TABLE digitalemedien_author
    ADD CONSTRAINT digitalemedien_author_autor_fk FOREIGN KEY ( autor_id )
        REFERENCES autor ( id );

--  ERROR: FK name length exceeds maximum allowed length(30)
ALTER TABLE digitalemedien_author
    ADD CONSTRAINT digitalemedien_author_digitale_medien_fk FOREIGN KEY ( digitalemedien_id )
        REFERENCES digitale_medien ( id );

ALTER TABLE "E-Book"
    ADD CONSTRAINT "E-Book_Digitale_Medien_FK" FOREIGN KEY ( id )
        REFERENCES digitale_medien ( id );

-- Error - Foreign Key Genre_Buch_FK has no columns

ALTER TABLE genre
    ADD CONSTRAINT genre_digitale_medien_fk FOREIGN KEY ( digitale_medien_medien_id )
        REFERENCES digitale_medien ( id );

ALTER TABLE hörbuch
    ADD CONSTRAINT hörbuch_digitale_medien_fk FOREIGN KEY ( id )
        REFERENCES digitale_medien ( id );

ALTER TABLE hörbuch_sprecher
    ADD CONSTRAINT hörbuch_sprecher_hörbuch_fk FOREIGN KEY ( hörbuch_id )
        REFERENCES hörbuch ( id );

ALTER TABLE hörbuch_sprecher
    ADD CONSTRAINT hörbuch_sprecher_sprecher_fk FOREIGN KEY ( vorleser_vorleser_id )
        REFERENCES sprecher ( vorleser_id );

ALTER TABLE medien
    ADD CONSTRAINT medien_sprache_fk FOREIGN KEY ( sprache_id )
        REFERENCES sprache ( id );

ALTER TABLE medien_topic
    ADD CONSTRAINT medien_topic_medien_fk FOREIGN KEY ( medien_id )
        REFERENCES medien ( id );

ALTER TABLE medien_topic
    ADD CONSTRAINT medien_topic_topic_fk FOREIGN KEY ( topic_id )
        REFERENCES topic ( id );

ALTER TABLE medien
    ADD CONSTRAINT medien_verlag_fk FOREIGN KEY ( verlag_id )
        REFERENCES verlag ( id );

ALTER TABLE personal
    ADD CONSTRAINT personal_arbeitsort_fk FOREIGN KEY ( arbeitsort_id )
        REFERENCES arbeitsort ( id );

ALTER TABLE personal
    ADD CONSTRAINT personal_kunde_fk FOREIGN KEY ( kunde_id )
        REFERENCES kunde ( id );

ALTER TABLE physische_medien
    ADD CONSTRAINT physische_medien_medien_fk FOREIGN KEY ( id )
        REFERENCES medien ( id );

ALTER TABLE rechnung
    ADD CONSTRAINT rechnung_kunde_fk FOREIGN KEY ( kunde_id )
        REFERENCES kunde ( id );

ALTER TABLE rechnung
    ADD CONSTRAINT rechnung_physische_medien_fk FOREIGN KEY ( medien_id )
        REFERENCES physische_medien ( id );

ALTER TABLE reservierung
    ADD CONSTRAINT reservierung_kunde_fk FOREIGN KEY ( kunde_id )
        REFERENCES kunde ( id );

ALTER TABLE reservierung
    ADD CONSTRAINT reservierung_medien_fk FOREIGN KEY ( medien_id )
        REFERENCES medien ( id );

ALTER TABLE ausleihung
    ADD CONSTRAINT verleih_kunde_fk FOREIGN KEY ( kunde_id )
        REFERENCES kunde ( id );

ALTER TABLE ausleihung
    ADD CONSTRAINT verleih_medien_fk FOREIGN KEY ( medien_id )
        REFERENCES medien ( id );

--  ERROR: FK name length exceeds maximum allowed length(30)
ALTER TABLE zeitschrift
    ADD CONSTRAINT zeitschrift_physische_medien_fk FOREIGN KEY ( id )
        REFERENCES physische_medien ( id );

ALTER TABLE zeitung
    ADD CONSTRAINT zeitung_physische_medien_fk FOREIGN KEY ( id )
        REFERENCES physische_medien ( id );

CREATE SEQUENCE physische_medien_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER physische_medien_id_trg BEFORE
    INSERT ON physische_medien
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    :new.id := physische_medien_id_seq.nextval;
END;
/

CREATE SEQUENCE sprecher_vorleser_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER sprecher_vorleser_id_trg BEFORE
    INSERT ON sprecher
    FOR EACH ROW
    WHEN ( new.vorleser_id IS NULL )
BEGIN
    :new.vorleser_id := sprecher_vorleser_id_seq.nextval;
END;
/



-- Zusammenfassungsbericht für Oracle SQL Developer Data Modeler:
--
-- CREATE TABLE                            25
-- CREATE INDEX                            10
-- ALTER TABLE                             52
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           2
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          2
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
--
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
--
-- REDACTION POLICY                         0
--
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
--
-- ERRORS                                  16
-- WARNINGS                                 0
