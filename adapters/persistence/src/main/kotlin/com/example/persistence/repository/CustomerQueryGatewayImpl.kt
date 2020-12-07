package com.example.persistence.repository

import com.example.domain.customer.Customer
import com.example.domain.customer.CustomerConverter
import com.example.domain.customer.CustomerQueryGateway
import com.example.port.dto.CustomerDTO
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Default
import javax.inject.Inject
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@ApplicationScoped
class CustomerRepository : PanacheRepositoryBase<Customer, Int>

@Default
@ApplicationScoped
class CustomerQueryGatewayImpl: CustomerQueryGateway {

    @PersistenceContext
    internal lateinit var entityManager: EntityManager

    @Inject
    internal lateinit var repository: CustomerRepository

    @Inject
    internal lateinit var customerConverter: CustomerConverter

    override fun fetch(id: Int): CustomerDTO {
        val customer = repository.findById(id) ?: throw Exception("Customer not found")
        return customerConverter.convertToDTO(customer)
    }

    override fun findAll(): List<CustomerDTO> {
        return customerConverter.convertToDTO(repository.findAll().list<Customer>())
    }
}