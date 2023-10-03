package com.antonio.conversionService

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class ConversionServiceApplication

fun main(args: Array<String>) {
	runApplication<ConversionServiceApplication>(*args)
}
