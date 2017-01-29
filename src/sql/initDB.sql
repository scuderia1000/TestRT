DROP TABLE IF EXISTS users;

DROP SEQUENCE IF EXISTS auto_id_users;

CREATE SEQUENCE auto_id_users;

CREATE TABLE users
(
  "id" integer NOT NULL DEFAULT nextval('auto_id_users'),
  "last_name" varchar(255) NOT NULL,
  "first_name" varchar(255) NOT NULL,
  "middle_name" varchar(255) NOT NULL,
  "city" varchar(255) NOT NULL
);

CREATE SEQUENCE auto_id_user_cars;

CREATE TABLE user_cars
(
  "id" integer NOT NULL DEFAULT nextval('auto_id_user_cars'),
  "user_id" integer NOT NULL,
  "model" varchar(255) NOT NULL
)