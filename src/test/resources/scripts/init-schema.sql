CREATE TABLE countries (
  id     SERIAL,
  name   VARCHAR(32)   NOT NULL UNIQUE,
  tariff NUMERIC(8, 2) NOT NULL,
  CONSTRAINT countries_pkey PRIMARY KEY (id)
);

CREATE TABLE cities (
  id         SERIAL,
  id_country INT            NOT NULL,
  name       VARCHAR(32)    NOT NULL,
  latitude   NUMERIC(10, 7) NOT NULL,
  longitude  NUMERIC(10, 7) NOT NULL,
  tariff     NUMERIC(6, 2)  NOT NULL,
  CONSTRAINT cities_pkey PRIMARY KEY (id),
  FOREIGN KEY (id_country) REFERENCES countries (id)
  ON UPDATE CASCADE
  ON DELETE RESTRICT
);

CREATE TABLE branches (
  id            SERIAL,
  id_city       INT         NOT NULL,
  street        VARCHAR(32) NOT NULL,
  street_number VARCHAR(8)  NOT NULL,
  CONSTRAINT branches_pkey PRIMARY KEY (id),
  FOREIGN KEY (id_city) REFERENCES cities (id)
  ON UPDATE CASCADE
  ON DELETE RESTRICT
);

CREATE TABLE users (
  id         UUID,
  username   VARCHAR(16) NOT NULL UNIQUE,
  password   VARCHAR(20) NOT NULL DEFAULT 'NOT SET', -- Maybe 40
  email      VARCHAR(32) UNIQUE,
  first_name VARCHAR(32) NOT NULL,
  last_name  VARCHAR(32) NOT NULL,
  role       VARCHAR(8)  NOT NULL,
  CONSTRAINT users_pkey PRIMARY KEY (id)
);

CREATE TABLE parcels (
  id                 UUID,
  id_sender          UUID                     NOT NULL,
  id_receiver        UUID                     NOT NULL,
  id_branch_sender   INT                      NOT NULL,
  id_branch_receiver INT                      NOT NULL,
  issue_date         TIMESTAMP WITH TIME ZONE NOT NULL,
  status             VARCHAR(16)              NOT NULL,
  is_paid            BOOLEAN                  NOT NULL DEFAULT FALSE,
  price_total        NUMERIC(10, 2)           NOT NULL,
  CONSTRAINT parcels_pkey PRIMARY KEY (id),
  FOREIGN KEY (id_sender) REFERENCES users (id)
  ON UPDATE CASCADE
  ON DELETE RESTRICT,
  FOREIGN KEY (id_receiver) REFERENCES users (id)
  ON UPDATE CASCADE
  ON DELETE RESTRICT,
  FOREIGN KEY (id_branch_sender) REFERENCES branches (id)
  ON UPDATE CASCADE
  ON DELETE RESTRICT,
  FOREIGN KEY (id_branch_receiver) REFERENCES branches (id)
  ON UPDATE CASCADE
  ON DELETE RESTRICT
);

CREATE TABLE goods (
  id             UUID,
  id_parcel      UUID          NOT NULL,
  weight         NUMERIC(7, 3) NOT NULL,
  length         INT           NOT NULL,
  width          INT           NOT NULL,
  height         INT           NOT NULL,
  assessed_value NUMERIC(8, 2) NOT NULL,
  CONSTRAINT goods_pkey PRIMARY KEY (id),
  FOREIGN KEY (id_parcel) REFERENCES parcels (id)
  ON UPDATE CASCADE
  ON DELETE CASCADE
);

CREATE TABLE deliveries (
  id            UUID,
  id_parcel     UUID        NOT NULL,
  is_delivered  BOOLEAN     NOT NULL DEFAULT FALSE,
  id_city       INT         NOT NULL,
  street        VARCHAR(32) NOT NULL,
  street_number VARCHAR(8)  NOT NULL,
  CONSTRAINT deliveries_pkey PRIMARY KEY (id),
  FOREIGN KEY (id_parcel) REFERENCES parcels (id)
  ON UPDATE CASCADE
  ON DELETE CASCADE,
  FOREIGN KEY (id_city) REFERENCES cities (id)
  ON UPDATE CASCADE
  ON DELETE RESTRICT
);