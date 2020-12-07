package com.example.domain.customer

import com.example.port.dto.CustomerDTO

interface CustomerQueryGateway {
    fun fetch(id: Int): CustomerDTO
    fun findAll() : List<CustomerDTO>
}