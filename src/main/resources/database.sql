
CREATE SEQUENCE auto_id_users;
--Table: users
CREATE TABLE users (
  id       INTEGER NOT NULL UNIQUE DEFAULT nextval('auto_id_users'),
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL
);

CREATE SEQUENCE auto_id_roles;
--Table: roles
CREATE TABLE roles (
  id   INTEGER NOT NULL UNIQUE DEFAULT nextval('auto_id_roles'),
  name VARCHAR(100) NOT NULL
);

--Table for mapping user and roles : user_roles
CREATE TABLE user_roles(
  user_id INTEGER NOT NULL,
  role_id INTEGER NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (role_id) REFERENCES roles(id),

  UNIQUE (user_id,role_id)
);


--Insert
INSERT INTO users(username,password) VALUES ('artemenko', '$2a$11$uSXS6rLJ91WjgOHhEGDx..VGs7MkKZV68Lv5r1uwFu7HgtRn3dcXG');

INSERT INTO roles(name) VALUES ('ROLE_USER');
INSERT INTO roles(name) VALUES ('ROLE_ADMIN');

INSERT INTO user_roles VALUES (1, 2);