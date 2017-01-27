DROP TABLE IF EXISTS users;
-- Создание счетчика
CREATE SEQUENCE auto_id_users;
-- Создание таблицы
CREATE TABLE users
(
  "id" integer NOT NULL DEFAULT nextval('auto_id_users'),
  "last_name" varchar(255) NOT NULL,
  "first_name" varchar(255) NOT NULL,
  "middle_name" varchar(255) NOT NULL,
  "city" varchar(255) NOT NULL
)