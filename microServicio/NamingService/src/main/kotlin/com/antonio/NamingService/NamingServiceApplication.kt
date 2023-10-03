package com.antonio.NamingService

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@EnableEurekaServer
@SpringBootApplication
class NamingServiceApplication

fun main(args: Array<String>) {
	runApplication<NamingServiceApplication>(*args)
}
