DROP DATABASE IF EXISTS school;
CREATE DATABASE school;

USE school;

CREATE TABLE guardian(
	id	INT	AUTO_INCREMENT	PRIMARY KEY,
	first_name VARCHAR(20)	NOT NULL,
    last_name	VARCHAR(50)	NOT NULL,
    address	VARCHAR(100)	NOT NULL,
    phoneNr VARCHAR(15)		NOT NULL,
    email	VARCHAR(100)	NOT NULL
);

CREATE TABLE class(
    name VARCHAR(15)	PRIMARY KEY
);

CREATE TABLE child(
	id	INT AUTO_INCREMENT	PRIMARY KEY,
    first_name VARCHAR(20)	NOT NULL,
    last_name	VARCHAR(50)	NOT NULL,
    class	VARCHAR(15),
	birthday 	DATE NOT NULL,
    CONSTRAINT fk_class
		FOREIGN KEY (class)
        REFERENCES class(name)
);

CREATE TABLE teacher(
	id	INT		AUTO_INCREMENT	PRIMARY KEY,
    first_name VARCHAR(20)	NOT NULL,
    last_name	VARCHAR(50)	NOT NULL,
    address	VARCHAR(100)	NOT NULL,
    phoneNr	VARCHAR(15)		NOT NULL,
    email	VARCHAR(100)	NOT NULL
);

CREATE TABLE child_guardian_relationship(
	guardian_id	INT,
    child_id INT,
    CONSTRAINT fk_guardian_id
		FOREIGN KEY(guardian_id)
        REFERENCES guardian(id)
        ON DELETE CASCADE,
	CONSTRAINT fk_child_id
		FOREIGN KEY(child_id)
        REFERENCES child(id)
        ON DELETE CASCADE
);

CREATE TABLE teacher_class_relationship(
	teacher_id	INT,
    name VARCHAR(15),
	CONSTRAINT fk_teacher_id
		FOREIGN KEY(teacher_id)
        REFERENCES teacher(id)
        ON DELETE CASCADE,
	CONSTRAINT fk_name
		FOREIGN KEY(name)
        REFERENCES class(name)
        ON DELETE CASCADE
);

DROP USER IF EXISTS employee@localhost;
DROP USER IF EXISTS administrator@localhost;

CREATE USER employee@localhost IDENTIFIED BY "password";
GRANT SELECT
	ON school.*
	TO employee@localhost;
    
CREATE USER administrator@localhost IDENTIFIED BY "admin_pass";
GRANT SELECT, INSERT, UPDATE, DELETE 
	ON school.*
	TO administrator@localhost;