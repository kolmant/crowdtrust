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

        return "index.html"
    }
}
