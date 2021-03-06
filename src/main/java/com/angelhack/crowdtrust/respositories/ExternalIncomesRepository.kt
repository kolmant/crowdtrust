package com.angelhack.crowdtrust.respositories

import com.angelhack.crowdtrust.entities.projects.ExternalIncomes
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class ExternalIncomesRepository {
    @Autowired
    private lateinit var jdbcTemplate: NamedParameterJdbcTemplate

    fun getByProjectId(id: Int): List<ExternalIncomes> {
        return jdbcTemplate.query(
                "SELECT *, external_user_id as donatorId FROM external_incomes where project_id = :id",
                mapOf("id" to id),
                BeanPropertyRowMapper(ExternalIncomes::class.java))
    }

}
