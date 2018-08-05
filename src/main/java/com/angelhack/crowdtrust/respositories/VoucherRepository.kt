package com.angelhack.crowdtrust.respositories

import com.angelhack.crowdtrust.entities.projects.ExternalIncomes
import com.angelhack.crowdtrust.entities.projects.Voucher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class VoucherRepository {

    @Autowired
    private lateinit var jdbcTemplate: NamedParameterJdbcTemplate

    fun getByVoucherId(id: Int): Voucher {
        return jdbcTemplate.query(
                "SELECT *, filename as fileName FROM outgoing_voucher where id = :id",
                mapOf("id" to id),
                BeanPropertyRowMapper(Voucher::class.java))[0]
    }

}
