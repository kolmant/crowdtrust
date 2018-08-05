CREATE TABLE outgoing_sub_types
(
  id SERIAL PRIMARY KEY,
  name varchar(255) NOT NULL ,
  outgoing_type_id INTEGER references outgoing_types(id) NOT NULL
);
