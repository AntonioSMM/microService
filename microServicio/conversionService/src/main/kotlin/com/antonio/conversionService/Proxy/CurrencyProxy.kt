package com.antonio.conversionService.Proxy

import com.antonio.conversionService.Models.ConversionModel
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

//@FeignClient(name="currency-exchange", url = "localhost:8000")
@FeignClient(name="currency-exchange")
interface CurrencyProxy {

    @GetMapping("/currency/from/{from}/to/{to}")
    fun exchange(@PathVariable from:String,
                 @PathVariable to:String): ConversionModel

}