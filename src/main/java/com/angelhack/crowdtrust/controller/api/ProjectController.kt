package com.angelhack.crowdtrust.controller.api

import com.angelhack.crowdtrust.entities.Project
import com.angelhack.crowdtrust.services.ProjectService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/projects")
class ProjectController {
    @Autowired
    private lateinit var projectService: ProjectService;

    @GetMapping("all")
    @ResponseBody
    fun getAll(): List<Project>{
        val projects = projectService.getAllProjects();
        return projects
    }
}
