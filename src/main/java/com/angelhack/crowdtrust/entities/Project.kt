package com.angelhack.crowdtrust.entities

import com.angelhack.crowdtrust.entities.projects.ExternalIncomes
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate

import java.time.LocalDateTime

/**
 * Created by David Useche on 4/08/2018.
 */
class Project(){
    var id: Int = 0

    lateinit var name: String

    lateinit var description: String

    var image: String = ""

    @JsonProperty("expected_budget")
    var expectedBudget: Float = 0.0f

    @JsonProperty("expected_init_date")
    lateinit var expectedInitDate: LocalDate

    @JsonProperty("expected_end_date")
    lateinit var expectedEndDate: LocalDate

    lateinit var organizations: List<Organization>

    lateinit var incomes: List<ExternalIncomes>
}
