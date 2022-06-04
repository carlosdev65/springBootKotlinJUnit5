package tv.codealong.tutorials.springboot.thenreboston.datasource.mock

import org.springframework.stereotype.Repository
import tv.codealong.tutorials.springboot.thenreboston.datasource.BankDataSource
import tv.codealong.tutorials.springboot.thenreboston.model.Bank

@Repository
class MockBankDataSource : BankDataSource{

    val banks = mutableListOf(
        Bank("1234",3.14,17),
        Bank("1010",17.0,0),
        Bank("5678",0.0,100)
    )

    override fun retrieveBanks(): Collection<Bank> = banks
    override fun retriveBank(accountNumber: String): Bank =
        banks.firstOrNull() {it.accountNumber == accountNumber}
            ?: throw NoSuchElementException("Could not find a bank with account number $accountNumber")

    override fun createBank(bank: Bank): Bank {
        if(banks.any {it.accountNumber == bank.accountNumber}){
            throw IllegalArgumentException("Bank with account number ${bank.accountNumber} already exists. ")
        }
        banks.add(bank)

        return bank
    }

}