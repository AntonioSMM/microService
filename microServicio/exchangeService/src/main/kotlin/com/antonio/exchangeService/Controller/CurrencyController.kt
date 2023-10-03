package com.antonio.exchangeService.Controller

import com.antonio.exchangeService.Models.CurrencyModel
import com.antonio.exchangeService.Repository.CurrencyRepo
import org.springframework.core.env.Environment
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal


@RestController
class CurrencyController(var environment: Environment, var currencyRepo: CurrencyRepo) {




    @GetMapping("/currency/from/{from}/to/{to}")
    fun exchange(@PathVariable from:String,
                 @PathVariable to:String): CurrencyModel {

        var currency = currencyRepo.findByFromAndTo(from,to)

        if (currency == null) {
            throw NoSuchElementException("No se encontro la consulta")
        }

        var port = environment.getProperty("local.server.port")

        currency.environment=(port)



        return currency
    }
}