package com.antonio.ApiGateway

import org.springframework.cloud.gateway.route.Route
import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.Buildable
import org.springframework.cloud.gateway.route.builder.PredicateSpec
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import java.util.function.Function


@Configuration
class ApiGatewayConfiguration {



    @Bean
    fun router (builder: RouteLocatorBuilder): RouteLocator {

        val routeFunction : (PredicateSpec) -> Buildable<Route> = {
            p -> p.path("/currency-exchange/**")
            .uri("lb://currency-exchange")
        }

        return builder.routes().route(routeFunction).build()
    }

}