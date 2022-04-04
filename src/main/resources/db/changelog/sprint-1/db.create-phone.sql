--liquibase formatted sql

--changeset liquibase:1

    CREATE TABLE phone (
        id BIGINT NOT NULL AUTO_INCREMENT,
        person_id BIGINT NOT NULL,
        phone_number VARCHAR(14) NOT NULL,
        phone_type VARCHAR(12) NOT NULL,

        PRIMARY KEY (id)
    );

    ALTER TABLE phone ADD CONSTRAINT fk_phone_person
    FOREIGN KEY (person_id) REFERENCES person (id)