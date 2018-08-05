package com.angelhack.crowdtrust.services

import com.angelhack.crowdtrust.entities.Project
import com.angelhack.crowdtrust.respositories.ProjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProjectService {
    @Autowired
    private lateinit var projectRepository: ProjectRepository;

    @Autowired
    private lateinit var organizationService: OrganizationService

    @Autowired
    private lateinit var externalIncomesService: ExternalIncomesService

    fun getAllProjects() : List<Project>{
        val projects = projectRepository.getAll()
        projects.forEach({
            it.organizations = organizationService.getByProjectId(it.id)
            it.incomes = externalIncomesService.getByProjectId(it.id)
        })
        return projects
    }
}
