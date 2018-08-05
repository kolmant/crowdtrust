package com.angelhack.crowdtrust.respositories

import com.angelhack.crowdtrust.entities.Organization
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class OrganizationRepository {
    @Autowired
    private lateinit var jdbcTemplate: NamedParameterJdbcTemplate

    fun getByProjectId(projectId: Int): List<Organization> {
        return jdbcTemplate.query(
                "SELECT o.name as name, o.id as id FROM pivot_organizations_projects op " +
                        "INNER JOIN organizations o ON op.organization_id = o.id " +
                        "WHERE op.project_id = :projectId",
                mapOf("projectId" to projectId),
                BeanPropertyRowMapper(Organization::class.java))
    }
}
