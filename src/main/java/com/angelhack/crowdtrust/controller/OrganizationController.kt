package com.angelhack.crowdtrust.controller

import com.angelhack.crowdtrust.services.ProjectService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class OrganizationController {

    @Autowired
    private lateinit var projectService: ProjectService


    @GetMapping("/")
    fun getOrganizations(model: Model): String {

        val projects = projectService.getAllProjects()

        val organizations = projects.flatMap { it.organizations }.distinctBy { it.id }

        model.addAttribute("projects", projects)
        model.addAttribute("organizations", organizations)

        return "index.html"
    }

    @GetMapping("/project/{id}")
    fun getProject(model: Model, @PathVariable id: Int): String {

        val project = projectService.getProjectById(id)

        val organizations = project.organizations

        val outgoings = arrayListOf<Principal>()

        val totalOutgoings = project.outgoings.sumBy { it.totalPrice }

        project.outgoings.forEach { out ->
            val outgoing = outgoings.filter { it.name == out.type }
            if (outgoing.isNotEmpty()){
                val subtype = outgoing[0].detail.filter { it.name == out.subtype }
                if (subtype.isNotEmpty()){
                    outgoing[0].detail[0].detail.add(Tercera(
                            out.quantity,
                            out.totalPrice,
                            out.voucherId,
                            out.projectId,
                            ((out.totalPrice+0.0)/totalOutgoings)*100.0
                    ))
                    outgoing[0].detail[0].quantity += out.quantity
                    outgoing[0].detail[0].total += out.totalPrice
                    outgoing[0].detail[0].percentage = ((outgoing[0].detail[0].total+0.0)/totalOutgoings)*100.0

                    outgoing[0].quantity += out.quantity
                    outgoing[0].total += out.totalPrice
                    outgoing[0].percentage = ((outgoing[0].total+0.0)/totalOutgoings)*100.0
                }else{
                    outgoing[0].detail.add(
                            Secundary(
                            out.subtype,
                            arrayListOf(Tercera(
                                    out.quantity,
                                    out.totalPrice,
                                    out.voucherId,
                                    out.projectId,
                                    ((out.totalPrice+0.0)/totalOutgoings)*100.0
                            )),
                            out.totalPrice,
                                    ((out.totalPrice+0.0)/totalOutgoings)*100.0,
                            out.quantity)
                    )
                    outgoing[0].quantity += out.quantity
                    outgoing[0].total += out.totalPrice
                    outgoing[0].percentage = ((outgoing[0].total+0.0)/totalOutgoings)*100.0
                }
            }else{
                outgoings.add(Principal(
                        out.type,
                        arrayListOf(Secundary(
                                out.subtype,
                                arrayListOf(Tercera(
                                        out.quantity,
                                        out.totalPrice,
                                        out.voucherId,
                                        out.projectId,
                                        ((out.totalPrice+0.0)/totalOutgoings)*100.0
                                )),
                                out.totalPrice,
                                ((out.totalPrice+0.0)/totalOutgoings)*100.0,
                                out.quantity)),
                        out.totalPrice,
                        ((out.totalPrice+0.0)/totalOutgoings)*100.0,
                        out.quantity
                ))
            }
        }

        outgoings.sortByDescending { it.total }

        model.addAttribute("project", project)
        model.addAttribute("organizations", organizations)
        model.addAttribute("outgoings", outgoings)

        return "project.html"
    }
}

class Principal(
    var name: String,
    var detail: ArrayList<Secundary>,
    var total: Int,
    var percentage: Double,
    var quantity: Int
)

class Secundary(
        var name: String,
        var detail: ArrayList<Tercera>,
        var total: Int,
        var percentage: Double,
        var quantity: Int
)

class Tercera(
        var quantity: Int,
        var total: Int,
        var voucherId: Int,
        var projectId: Int,
        var percentage: Double
)
