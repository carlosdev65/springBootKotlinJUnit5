package tv.codealong.tutorials.springboot.thenreboston.datasource

import tv.codealong.tutorials.springboot.thenreboston.model.Bank

interface BankDataSource {
    fun retrieveBanks() : Collection<Bank>

    fun retriveBank(accountNumber: String): Bank

    fun createBank(bank: Bank): Bank
}