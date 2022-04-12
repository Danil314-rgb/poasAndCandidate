CREATE TABLE users
(
    id       SERIAL PRIMARY KEY,
    name     TEXT,
    email    TEXT,
    password TEXT
);

CREATE TABLE candidates
(
    id          SERIAL PRIMARY KEY,
    name        TEXT,
    description TEXT,
    created     TIMESTAMP,
    photo       bytea
);

CREATE TABLE cities
(
    id   SERIAL PRIMARY KEY,
    name TEXT
);

INSERT INTO cities(name) VALUES ('Москва');
INSERT INTO cities(name) VALUES ('СПб');
INSERT INTO cities(name) VALUES ('Екб');
INSERT INTO cities(name) VALUES ('Сам');

CREATE TABLE posts
(
    id          SERIAL PRIMARY KEY,
    name        TEXT,
    description TEXT,
    city_id     INT REFERENCES cities (id)
);