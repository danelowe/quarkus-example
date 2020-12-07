package com.example.domain.customer

import com.example.port.service.CustomerQueryService
import com.example.port.dto.CustomerDTO
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Default
import javax.inject.Inject
import javax.transaction.Transactional

@ApplicationScoped
@Transactional
@Default
class CustomerQueryServiceImpl : CustomerQueryService {

    @Inject
    @field: Default
    internal lateinit var customerQueryGateway: CustomerQueryGateway

    override fun fetch(id: Int): CustomerDTO {
        return customerQueryGateway.fetch(id)
    }

    override fun findAll(): List<CustomerDTO> {
        return customerQueryGateway.findAll()
    }
}