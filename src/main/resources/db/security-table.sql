CREATE TABLE users (
  username VARCHAR NOT NULL PRIMARY KEY,
  password VARCHAR NOT NULL,
  enabled  BOOLEAN NOT NULL
);

CREATE TABLE authorities (
  username  VARCHAR NOT NULL REFERENCES users (username),
  authority VARCHAR NOT NULL
);

-- ==================================================================

INSERT INTO USERS (username, password, enabled) VALUES ('admin', 'admin', TRUE);
INSERT INTO USERS (username, password, enabled) VALUES ('user', 'user', TRUE);

INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER');