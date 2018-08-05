package com.angelhack.crowdtrust.services

import com.angelhack.crowdtrust.entities.Project
import com.angelhack.crowdtrust.respositories.ProjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProjectService {
    @Autowired
    private lateinit var projectRepository: ProjectRepository

    @Autowired
    private lateinit var organizationService: OrganizationService

    @Autowired
    private lateinit var externalIncomesService: ExternalIncomesService

    @Autowired
    private lateinit var organizationIncomesService: OrganizationIncomesService

    fun getAllProjects() : List<Project>{
        val projects = projectRepository.getAll()
        projects.forEach({
            it.organizations = organizationService.getByProjectId(it.id)
            it.externalIncomes = externalIncomesService.getByProjectId(it.id)
            it.organizationIncomes = organizationIncomesService.getByProjectId(it.id)
        })
        return projects
    }

    fun getProjectById(id:Int) : Project{
        val toReturn = projectRepository.getById(id)
        toReturn.organizations = organizationService.getByProjectId(id)
        toReturn.externalIncomes = externalIncomesService.getByProjectId(id)
        toReturn.organizationIncomes = organizationIncomesService.getByProjectId(id)
        return toReturn
    }
}
