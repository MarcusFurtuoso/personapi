--liquibase formatted sql

--changeset liquibase:1

    CREATE TABLE person (
        id BIGINT NOT NULL AUTO_INCREMENT,
        first_name VARCHAR(60) NOT NULL,
        last_name VARCHAR(60) NOT NULL,
        birth_date VARCHAR(15) NOT NULL,
        cpf VARCHAR(11) NOT NULL,

        PRIMARY KEY (id)
    );