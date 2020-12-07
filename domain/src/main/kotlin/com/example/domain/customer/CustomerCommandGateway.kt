package com.example.domain.customer


interface CustomerCommandGateway {
    fun fetch(id: Int): Customer?
    fun save(customer: Customer): Customer
}