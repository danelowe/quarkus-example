package com.example.domain

import com.example.domain.customer.CustomerQueryGateway
import org.mockito.Mockito.mock
import javax.enterprise.inject.Produces

object MockGateways {
    @Produces
    var customerQueryGateway: CustomerQueryGateway = mock(CustomerQueryGateway::class.java)
}