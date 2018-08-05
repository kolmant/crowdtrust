package com.angelhack.crowdtrust.services

import com.angelhack.crowdtrust.entities.projects.ExternalIncomes
import com.angelhack.crowdtrust.entities.projects.OutGoings
import com.angelhack.crowdtrust.entities.projects.Voucher
import com.angelhack.crowdtrust.respositories.ExternalIncomesRepository
import com.angelhack.crowdtrust.respositories.OutgoingsRepository
import com.angelhack.crowdtrust.respositories.VoucherRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class VoucherService {
    @Autowired
    private lateinit var voucherRepository: VoucherRepository

    fun getByVoucherId(id: Int): Voucher {
        return voucherRepository.getByVoucherId(id)
    }
}
