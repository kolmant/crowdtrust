package com.angelhack.crowdtrust.services

import com.angelhack.crowdtrust.entities.projects.ExternalIncomes
import com.angelhack.crowdtrust.entities.projects.OutGoings
import com.angelhack.crowdtrust.respositories.ExternalIncomesRepository
import com.angelhack.crowdtrust.respositories.OutgoingsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OutgoingsService {
    @Autowired
    private lateinit var outgoingsRepository: OutgoingsRepository

    fun getByProjectId(id: Int): List<OutGoings> {
        return outgoingsRepository.getByProjectId(id)
    }
}
