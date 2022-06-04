package tv.codealong.tutorials.springboot.thenreboston.service

import org.springframework.stereotype.Service
import tv.codealong.tutorials.springboot.thenreboston.datasource.BankDataSource
import tv.codealong.tutorials.springboot.thenreboston.model.Bank

@Service
class BankService(private val dataSource: BankDataSource) {
    fun getBanks(): Collection<Bank> = dataSource.retrieveBanks()
    fun getBank(accountNumber: String): Bank = dataSource.retriveBank(accountNumber)
    fun addBank(bank: Bank): Bank = dataSource.createBank(bank)

}