# pokemon-back-end Creation of database commands

- Terminal setup

```sql
-- type psql in terminal to launch postgresql
CREATE DATABASE pokemon;
```

- Postico setup

```sql
DROP TABLE IF EXISTS pokedex CASCADE;
DROP TABLE IF EXISTS trainer CASCADE;

CREATE TABLE trainer (
id SERIAL PRIMARY KEY NOT NULL,
name VARCHAR(50) NOT NULL,
email VARCHAR(50) NOT NULL,
password VARCHAR(255) NOT NULL,
sprite_link VARCHAR(255) NOT NULL
);

INSERT INTO trainer (name, email, password, sprite_link)
VALUES ('Nasir', 'nasir@gmail.com', 'password', 'changeme');

CREATE TABLE pokedex (
id SERIAL PRIMARY KEY NOT NULL,
trainer_id INT REFERENCES trainer(id) NOT NULL,
name VARCHAR(50) NOT NULL,
pokeapi_id INT NOT NULL,
sprite_link VARCHAR(255) NOT NULL,
hp INT NOT NULL,
level INT NOT NULL
);

INSERT INTO pokedex (trainer_id, name, pokeapi_id, sprite_link, hp, level)
VALUES (1, 'Bulbasaur', 1, 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png', 64, 5);

INSERT INTO pokedex (trainer_id, name, pokeapi_id, sprite_link, hp, level)
VALUES (1, 'Charmander', 4, 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png', 70, 6);

INSERT INTO pokedex (trainer_id, name, pokeapi_id, sprite_link, hp, level)
VALUES (1, 'Squirtle', 7, 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/7.png', 58, 4);

```
