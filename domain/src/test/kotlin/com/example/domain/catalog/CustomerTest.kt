package com.example.domain.catalog

import com.example.domain.customer.Customer
import io.quarkus.test.junit.QuarkusTest
import org.jboss.weld.junit5.auto.EnableAutoWeld
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


@EnableAutoWeld
class CustomerTest {
    //Note QuarkusTest would require all dependencies (or mocks) to be available.
    val customer = Customer.new("Test", "Person")

    @Test
    fun attributes_AssignValidValue_ShouldStoreValue() {
        customer.firstName = "tester"
        assertEquals("tester", customer.firstName)
    }
}