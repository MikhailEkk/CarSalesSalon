-- Добавляем роли
INSERT INTO roles (role_name) VALUES ('ROLE_ADMIN');
INSERT INTO roles (role_name) VALUES ('ROLE_USER');

-- Добавляем пользователей
INSERT INTO users (username, password) VALUES ('admin', '$2a$10$DOWSDWQEFOhG7CMbbzUBpO1vh5nm1kHlFw6.fEZoZoPi.nBBlxkEm'); -- admin (BCrypt)
INSERT INTO users (username, password) VALUES ('user', '$2a$10$DOWSDWQEFOhG7CMbbzUBpO1vh5nm1kHlFw6.fEZoZoPi.nBBlxkEm'); -- user (BCrypt)

-- Связываем пользователей с ролями
INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2);


Регистрация - готово
Отображение пользователя - готово
вторая БД для prod - ГОТОВО
Разграничить доступ к страницам для пользователя и админа - готово
по возможности добавить больше таблиц и функционала