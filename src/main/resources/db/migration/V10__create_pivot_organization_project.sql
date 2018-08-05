CREATE TABLE pivot_organizations_projects
(
  organization_id INTEGER references organizations(id) NOT NULL,
  project_id INTEGER references projects(id) NOT NULL
);
