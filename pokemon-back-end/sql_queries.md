# pokemon-back-end Creation of database commands

- Terminal setup

```sql
-- type psql in terminal to launch postgresql
CREATE DATABASE not_my_fitness_pal;
```

- Postico setup

```sql
CREATE TABLE people (
id SERIAL PRIMARY KEY,
name VARCHAR(255),
age INT,
height_in_cm DECIMAL(4,1),
weight_in_kg DECIMAL(4,1),
calorie_target INT
);

INSERT INTO people (name, age, height_in_cm, weight_in_kg, calorie_target)
VALUES ('Sarina', 22, 167.0, 58, 2000);


CREATE TABLE food_entries (
id SERIAL PRIMARY KEY,
person_id INT REFERENCES people(id) NOT NULL,
name VARCHAR(255),
meal_type VARCHAR(255),
notes TEXT,
calories INT,
week INT,
day VARCHAR(255)
);

INSERT INTO food_entries (person_id, name, meal_type, notes, calories, week, day)
VALUES (1, 'toast', 'BREAKFAST', 'Kingsmill 50/50 bread with butter', 60, 1, 'MONDAY');
INSERT INTO food_entries (person_id, name, meal_type, notes, calories, week, day)
VALUES (1, 'cereal', 'BREAKFAST', 'Curiously Cinnamon', 400, 1, 'TUESDAY');
