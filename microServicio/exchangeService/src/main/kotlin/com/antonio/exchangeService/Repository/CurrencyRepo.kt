package com.antonio.exchangeService.Repository

import com.antonio.exchangeService.Models.CurrencyModel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CurrencyRepo : CrudRepository<CurrencyModel,Long> {


    fun findByFromAndTo(from:String, to:String) : CurrencyModel?

}