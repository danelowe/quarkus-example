package com.example.domain.catalog

import com.example.port.service.CustomerQueryService
import io.quarkus.test.junit.QuarkusTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import javax.inject.Inject


@QuarkusTest
class CustomerQueryServiceImplTest {

    @Inject
    private lateinit var service: CustomerQueryService

    @Test
    fun findAll_ShouldQueryGateway() {
        val customers = service.findAll()
        assertEquals("tester", customers.first().firstName)
    }
}