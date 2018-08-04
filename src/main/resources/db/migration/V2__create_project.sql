CREATE TABLE projects
(
  id SERIAL PRIMARY KEY,
  name VARCHAR(255),
  description TEXT,
  image varchar(50),
  expected_budget float,
  expected_init_date timestamp,
  expected_end_date timestamp
);
