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
                "SELECT * FROM external_incomes where project_id = :projectId",
                mapOf("projectId" to projectId),
                BeanPropertyRowMapper(Organization::class.java))
    }
}
