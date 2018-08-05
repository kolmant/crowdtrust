package com.angelhack.crowdtrust.respositories

import com.angelhack.crowdtrust.entities.projects.ExternalIncomes
import com.angelhack.crowdtrust.entities.projects.OrganizationIncomes
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class OrganizationsIncomesRepository {
    @Autowired
    private lateinit var jdbcTemplate: NamedParameterJdbcTemplate

    fun getByProjectId(id: Int): List<OrganizationIncomes> {
        return jdbcTemplate.query(
                "SELECT * FROM organization_incomes where project_id = :projectId",
                mapOf("projectId" to id),
                BeanPropertyRowMapper(OrganizationIncomes::class.java))
    }

}
