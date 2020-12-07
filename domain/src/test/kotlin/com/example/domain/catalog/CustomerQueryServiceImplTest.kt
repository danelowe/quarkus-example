package com.example.domain.catalog

import com.example.domain.customer.CustomerQueryGateway
import com.example.domain.customer.CustomerQueryServiceImpl
import com.example.port.service.CustomerQueryService
import org.jboss.weld.junit5.auto.AddPackages
import org.jboss.weld.junit5.auto.EnableAutoWeld
import org.jboss.weld.junit5.auto.ExcludeBean
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import javax.enterprise.inject.Produces
import javax.inject.Inject
import org.mockito.Mockito.*


@EnableAutoWeld
@AddPackages(CustomerQueryServiceImpl::class)
class CustomerQueryServiceImplTest {
    //Note QuarkusTest would require all dependencies (or mocks) to be available.
    @Inject
    private lateinit var service: CustomerQueryService

    @Produces
    @ExcludeBean
    var mockGateway: CustomerQueryGateway = mock(CustomerQueryGateway::class.java)

    @Test
    fun findAll_ShouldQueryGateway() {
        val customers = service.findAll()
        assertEquals("tester", customers.first().firstName)
    }
}