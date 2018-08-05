package com.angelhack.crowdtrust.services

import com.angelhack.crowdtrust.entities.projects.ExternalIncomes
import com.angelhack.crowdtrust.entities.projects.OrganizationIncomes
import com.angelhack.crowdtrust.respositories.ExternalIncomesRepository
import com.angelhack.crowdtrust.respositories.OrganizationRepository
import com.angelhack.crowdtrust.respositories.OrganizationsIncomesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OrganizationIncomesService {
    @Autowired
    private lateinit var organizationsIncomesRepository: OrganizationsIncomesRepository

    fun getByProjectId(id: Int): List<OrganizationIncomes> {
        return organizationsIncomesRepository.getByProjectId(id)
    }
}
