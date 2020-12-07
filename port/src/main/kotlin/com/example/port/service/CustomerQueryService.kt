package com.example.port.service

import com.example.port.dto.CustomerDTO

interface CustomerQueryService {
    fun fetch(id: Int) : CustomerDTO
    fun findAll() : List<CustomerDTO>
}