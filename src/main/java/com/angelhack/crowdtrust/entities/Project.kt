package com.angelhack.crowdtrust.entities

import com.angelhack.crowdtrust.entities.projects.ExternalIncomes
import java.time.LocalDate

import java.time.LocalDateTime

/**
 * Created by David Useche on 4/08/2018.
 */
class Project(
        var id: Int,
        var name: String,
        var description: String,
        var imgName: String,
        var expectedBudget: Float,
        var expectedInitDate: LocalDate,
        var expectedEndDate: LocalDate,
        var organizations: List<Organization>,
        var incomes: List<ExternalIncomes>
)