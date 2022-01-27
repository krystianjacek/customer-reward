DROP TABLE IF EXISTS game;
CREATE TABLE game
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    current_player VARCHAR(10),
    user_name VARCHAR(255),
    game_state VARCHAR(300),
    game_status VARCHAR(10)

);

DROP TABLE IF EXISTS users;
CREATE TABLE users
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    role_id BIGINT

);

DROP TABLE IF EXISTS roles;
CREATE TABLE roles
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);
