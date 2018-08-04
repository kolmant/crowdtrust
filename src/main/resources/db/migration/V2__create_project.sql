CREATE TABLE projects
(
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  description TEXT NOT NULL,
  image varchar(50) NOT NULL,
  expected_budget float NOT NULL ,
  expected_init_date timestamp NOT NULL ,
  expected_end_date timestamp NOT NULL
);
