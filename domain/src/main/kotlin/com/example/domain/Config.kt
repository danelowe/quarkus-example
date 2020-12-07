package com.example.domain

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import javax.enterprise.inject.Produces
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD, AnnotationTarget.FUNCTION, AnnotationTarget.TYPE, AnnotationTarget.VALUE_PARAMETER)
annotation class DomainObjectMapper

object Config {
    @Produces
    @DomainObjectMapper
    fun domainObjectMapper() : ObjectMapper {
        return ObjectMapper().registerKotlinModule()
    }
}