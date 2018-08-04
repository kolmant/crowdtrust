CREATE TABLE organization_incomes
(
  id SERIAL PRIMARY KEY,
  quantity float NOT NULL ,
  organization_id integer references organizations(id) NOT NULL
);
