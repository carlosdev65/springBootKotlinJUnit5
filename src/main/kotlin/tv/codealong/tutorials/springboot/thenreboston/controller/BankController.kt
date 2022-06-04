package tv.codealong.tutorials.springboot.thenreboston.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import tv.codealong.tutorials.springboot.thenreboston.model.Bank
import tv.codealong.tutorials.springboot.thenreboston.service.BankService

@RestController
@RequestMapping("/api/banks")
class BankController(private val service: BankService) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.BAD_REQUEST)


    @GetMapping
    fun getBanks(): Collection<Bank> = service.getBanks()
    //fun getBanks(): String = "works"

    @GetMapping("/{accountNumber}")
    fun getBank(@PathVariable accountNumber: String): Bank = service.getBank(accountNumber)

//    @GetMapping("{/{accountNumber}")
//    fun getBank(@PathVariable accountNumber: String) = "You want about $accountNumber"
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addBanck(@RequestBody bank: Bank): Bank = service.addBank(bank)


}