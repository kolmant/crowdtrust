package com.angelhack.crowdtrust.respositories

import com.angelhack.crowdtrust.entities.projects.ExternalIncomes
import com.angelhack.crowdtrust.entities.projects.OutGoings
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class OutgoingsRepository {
    @Autowired
    private lateinit var jdbcTemplate: NamedParameterJdbcTemplate

    fun getByProjectId(id: Int): List<OutGoings> {
        return jdbcTemplate.query(
                "SELECT outgoings.*, subtype.name as subtype, type.name as type\n" +
                        "FROM outgoings\n" +
                        "       INNER JOIN outgoing_sub_types subtype ON subtype.id = outgoings.sub_type_id\n" +
                        "       INNER JOIN outgoing_types type ON type.id = subtype.outgoing_type_id\n" +
                        "where project_id = :id;",
                mapOf("id" to id),
                BeanPropertyRowMapper(OutGoings::class.java))
    }

}
