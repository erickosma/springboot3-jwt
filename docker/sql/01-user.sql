CREATE DATABASE auth;

CREATE SCHEMA login

CREATE TABLE login.user
(
    id   SERIAL PRIMARY KEY,
    email VARCHAR NOT NULL,
    pswd VARCHAR NOT NULL,
    created_at timestamp default NULL
);