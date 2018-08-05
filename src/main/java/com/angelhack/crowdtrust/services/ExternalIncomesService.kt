package com.angelhack.crowdtrust.services

import com.angelhack.crowdtrust.entities.projects.ExternalIncomes
import com.angelhack.crowdtrust.respositories.ExternalIncomesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ExternalIncomesService {
    @Autowired
    private lateinit var externalIncomesRepository : ExternalIncomesRepository

    fun getByProjectId(id: Int): List<ExternalIncomes> {
        return externalIncomesRepository.getByProjectId(id)
    }
}
