CREATE TABLE IF NOT EXISTS  users
(
    user_id serial PRIMARY KEY,
    name    VARCHAR(50) UNIQUE NOT NULL,
    age     INT                NOT NULL
);
