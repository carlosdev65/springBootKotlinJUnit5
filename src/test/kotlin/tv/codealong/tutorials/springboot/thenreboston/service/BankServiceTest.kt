package tv.codealong.tutorials.springboot.thenreboston.service

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import tv.codealong.tutorials.springboot.thenreboston.datasource.BankDataSource

internal class BankServiceTest {

    private val dataSource: BankDataSource = mockk(relaxed = true)

    private val bankService = BankService(dataSource)
    @Test
    fun `should call its data source to retrieve banks ` (){
//        //given
//        every { dataSource.retrieveBanks() } returns emptyList()
        // when
        bankService.getBanks()

        //then
        verify(exactly = 1) {dataSource.retrieveBanks()}
    }
}