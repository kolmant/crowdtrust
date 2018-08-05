package com.angelhack.crowdtrust.services

import com.angelhack.crowdtrust.entities.Organization
import com.angelhack.crowdtrust.respositories.OrganizationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OrganizationService {
    @Autowired
    private lateinit var organizationRepository: OrganizationRepository

    fun getByProjectId(projectId: Int):List<Organization>{
        return organizationRepository.getByProjectId(projectId)
    }
}
