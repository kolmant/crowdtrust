alter TABLE organization_incomes ADD COLUMN project_id INTEGER references projects(id);
alter TABLE external_incomes ADD COLUMN project_id INTEGER references projects(id);
alter TABLE outgoings ADD COLUMN project_id INTEGER references projects(id);

