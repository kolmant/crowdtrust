CREATE TABLE organization_incomes
(
  id SERIAL PRIMARY KEY,
  quantity float,
  organization_id integer references organizations(id)
);
