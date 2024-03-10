CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS app_user (
     `id` UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
     `username` varchar(20),
     `email` varchar(50)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE INDEX user_username_idx ON app_user (username);

CREATE TABLE IF NOT EXISTS route (
     userId UUID references app_user(name),
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(20),
    `email` varchar(50),
    `date_of_birth` timestamp

)ENGINE=InnoDB DEFAULT CHARSET=UTF8;