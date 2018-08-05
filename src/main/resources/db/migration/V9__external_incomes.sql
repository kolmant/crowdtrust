CREATE TABLE external_incomes
(
  id SERIAL PRIMARY KEY,
  quantity float NOT NULL,
  external_user_id integer NOT NULL
);
