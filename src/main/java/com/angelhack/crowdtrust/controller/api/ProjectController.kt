package com.angelhack.crowdtrust.controller.api

import com.angelhack.crowdtrust.entities.Project
import com.angelhack.crowdtrust.entities.projects.Voucher
import com.angelhack.crowdtrust.services.ProjectService
import com.angelhack.crowdtrust.services.VoucherService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/projects")
class ProjectController {
    @Autowired
    private lateinit var projectService: ProjectService

    @Autowired
    private lateinit var voucherService: VoucherService

    @GetMapping("all")
    @ResponseBody
    fun getAll(): List<Project>{
        val projects = projectService.getAllProjects()

        return projects
    }

    @GetMapping("/{id}")
    @ResponseBody
    fun getAll(@PathVariable id: Int): Project{
        val projects = projectService.getProjectById(id)

        return projects
    }

    @GetMapping("/voucher/{id}")
    @ResponseBody
    fun getVoucherById(@PathVariable id:Int): Voucher{
        val voucher = voucherService.getByVoucherId(id)

        return voucher
    }
}
