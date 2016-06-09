DROP TABLE IF EXISTS ALUNO;

CREATE TABLE ALUNO(
 CD_ALUNO     INTEGER NOT NULL ,
 NR_MATRICULA VARCHAR(10) NOT NULL ,
 NM_ALUNO     VARCHAR(250) NOT NULL ,
 DS_SENHA     VARCHAR(32) ,
 VL_IRA FLOAT
);
ALTER TABLE ALUNO ADD CONSTRAINT ALUNO_PK PRIMARY KEY ( CD_ALUNO ) ;

INSERT INTO ALUNO VALUES(1, '123', 'TESTE', '123', 1.5);
