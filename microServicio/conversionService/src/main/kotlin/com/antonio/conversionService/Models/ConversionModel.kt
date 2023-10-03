package com.antonio.conversionService.Models
import java.math.BigDecimal


data class ConversionModel(var id :Long?=null,
                           var from :String?=null,
                           var to :String?=null,
                           var quantity :BigDecimal?=null,
                            var conversionMultiple :BigDecimal?=null,
                            var totalCalculateAmount :BigDecimal?=null,
                            var environment :String?=null) {

}
