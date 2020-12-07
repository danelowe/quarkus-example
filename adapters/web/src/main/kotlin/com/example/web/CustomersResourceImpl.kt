package com.example.web

import com.example.port.service.CustomerQueryService
import com.example.port.dto.CustomerDTO
import javax.inject.Inject
import javax.ws.rs.*

class CustomersResourceImpl : CustomersResource
{
    @Inject
    lateinit var queryService: CustomerQueryService

    override fun list(): List<CustomerDTO> {
        return queryService.findAll()
    }

    override fun fetch(@PathParam("id") id: Int): CustomerDTO {
        return queryService.fetch(id)
    }

    override fun add(): CustomerDTO {
        TODO("Implement add")
    }

    override fun delete(@PathParam("id") id: Int): List<CustomerDTO> {
        TODO("Implement delete")
    }
}