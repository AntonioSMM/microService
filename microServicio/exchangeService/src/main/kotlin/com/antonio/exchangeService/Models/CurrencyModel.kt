package com.antonio.exchangeService.Models

import jakarta.persistence.*
import java.math.BigDecimal


@Entity
@Table(name = "moneda")
class CurrencyModel(
                    @get:Id
                    @get:GeneratedValue(strategy = GenerationType.IDENTITY)
                    var id :Long?=null,
                    @get:Column(name = "currencyFrom")
                    var from :String?=null,
                    @get:Column(name = "currencyTo")
                    var to :String?=null,
                    var conversionMultiple :BigDecimal?=null,
                    var environment :String?=null) {

}
