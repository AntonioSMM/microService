package com.antonio.conversionService.Controllers

import com.antonio.conversionService.Models.ConversionModel
import com.antonio.conversionService.Proxy.CurrencyProxy
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import java.math.BigDecimal


@RestController
class ConversionController (var currencyProxy: CurrencyProxy){



    //Usando RestTemplate para consumir la api
    @GetMapping("conversion/from/{from}/to/{to}/quantity/{quantity}")
    fun calculateConversion(@PathVariable from :String, @PathVariable to :String, @PathVariable quantity:BigDecimal) : ConversionModel? {

        var uriVariables : MutableMap<String,String> = mutableMapOf("from" to from, "to" to to)

        var consumoApi : ConversionModel? = RestTemplate().getForEntity(
            "http://localhost:8001/currency/from/{from}/to/{to}",
            ConversionModel::class.java, uriVariables).body

        var resultado : ConversionModel? = ConversionModel(consumoApi?.id,
                                                            from,
                                                            to,
                                                            quantity,
                                                            consumoApi?.conversionMultiple,
                                            quantity * consumoApi?.conversionMultiple!!,
                                                            consumoApi.environment
        )

        return resultado
    }


    //Usando OpenFeign
    @GetMapping("conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    fun calculateConversionFeign(@PathVariable from :String, @PathVariable to :String, @PathVariable quantity:BigDecimal) : ConversionModel? {


        var consumoApi : ConversionModel = currencyProxy.exchange(from, to)

        var resultado : ConversionModel? = ConversionModel(consumoApi.id,
            from,
            to,
            quantity,
            consumoApi.conversionMultiple,
            quantity * consumoApi.conversionMultiple!!,
            consumoApi.environment
        )

        return resultado
    }


}