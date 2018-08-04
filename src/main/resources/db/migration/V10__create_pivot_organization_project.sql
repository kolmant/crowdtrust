CREATE TABLE projects
(
  organization_id INTEGER references organizations(id),
  project_id INTEGER references projects(id)
);
