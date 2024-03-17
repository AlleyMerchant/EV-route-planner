CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE IF NOT EXISTS app_user (
     id UUID PRIMARY KEY,
     email TEXT,
     username VARCHAR(20),
     password TEXT,
     updatedAt TIMESTAMP,
     UNIQUE (username),
     UNIQUE (email),
     UNIQUE (username, password)
);

CREATE INDEX user_username_password_idx ON app_user (username, password);

CREATE TABLE IF NOT EXISTS ev_charger_route (
    id UUID PRIMARY KEY,
    user_id UUID REFERENCES app_user(id) ON DELETE CASCADE,
    name VARCHAR(20),
    route_json JSONB,
    commentable BOOLEAN,
    UNIQUE (name),
    UNIQUE(user_id, name)
);

CREATE INDEX ev_charger_route_user_id_id_idx ON ev_charger_route (user_id, id);
CREATE INDEX ev_charger_route_commentable_idx ON ev_charger_route (commentable);


CREATE TABLE IF NOT EXISTS comment (
     id UUID PRIMARY KEY,
     user_id UUID REFERENCES app_user(id) ON DELETE CASCADE,
     route_id UUID REFERENCES ev_charger_route(id) ON DELETE CASCADE,
     comment TEXT,
     updatedAt TIMESTAMP
)