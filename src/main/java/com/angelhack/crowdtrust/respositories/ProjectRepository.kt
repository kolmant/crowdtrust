package com.angelhack.crowdtrust.respositories

import com.angelhack.crowdtrust.entities.Organization
import com.angelhack.crowdtrust.entities.Project
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class ProjectRepository {
    @Autowired
    private lateinit var jdbcTemplate: NamedParameterJdbcTemplate

    fun getAll(): List<Project> {
        return jdbcTemplate.query(QUERY_GET_ALL, BeanPropertyRowMapper(Project::class.java))
    }
    private val QUERY_GET_ALL = "SELECT * from projects"

    fun getById(id:Int): Project {
        return jdbcTemplate.query(
                "SELECT *, expected_init_date as expectedInitDate, expected_end_date as expectedEndDate FROM projects where id = :id",
                mapOf("id" to id),
                BeanPropertyRowMapper(Project::class.java))[0]
    }
}
