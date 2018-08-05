package com.angelhack.crowdtrust.controller

import com.angelhack.crowdtrust.entities.Organization
import com.angelhack.crowdtrust.entities.Project
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Controller
class OrganizationController {

    @GetMapping("/")
    fun getOrganizations(model: Model): String {

        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")

        val epm = Organization("EPM",1)
        val cruzRoja = Organization("Cruz Roja",2)
        val transpColombia = Organization("Transparencia Colombia",3)

        val cruzRojaProj = Project(
                1,
                "Proj 1 - Cruz Roja",
                "Proj 1 - Cruz Roja",
                "hola.png",
                10000F,
                LocalDate.parse("01-01-2018", formatter),
                LocalDate.parse("12-12-2018", formatter),
                listOf(cruzRoja),
                listOf()
        )

        val epmProj = Project(
                1,
                "Proj 1 - EPM",
                "Proj 1 - EPM",
                "hola.png",
                10000F,
                LocalDate.parse("02-02-2018", formatter),
                LocalDate.parse("11-11-2018", formatter),
                listOf(epm),
                listOf()
        )

        val transparenciaColombiaProj = Project(
                1,
                "Proj 1 - Transp. Colombia",
                "Proj 1 - Transp. Colombia",
                "hola.png",
                10000F,
                LocalDate.parse("02-02-2018", formatter),
                LocalDate.parse("10-10-2018", formatter),
                listOf(transpColombia),
                listOf()
        )

        val conjuntoProj = Project(
                1,
                "Cruz Roja y EPM",
                "Conjunto",
                "hola.png",
                10000F,
                LocalDate.parse("02-02-2018", formatter),
                LocalDate.parse("09-09-2018", formatter),
                listOf(epm, cruzRoja),
                listOf()
        )

        val projects = listOf(epmProj, cruzRojaProj, transparenciaColombiaProj, conjuntoProj)
        val organizations = projects.flatMap { it.organizations }.distinctBy { it.id }

        model.addAttribute("projects", projects)
        model.addAttribute("organizations", organizations)

        return "index.html"
    }
}
