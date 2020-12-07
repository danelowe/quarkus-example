package com.example.persistence.repository

import com.example.domain.customer.CustomerConverter
import com.example.domain.customer.CustomerQueryGateway
import org.jboss.weld.junit5.auto.AddPackages
import org.jboss.weld.junit5.auto.EnableAutoWeld
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import javax.inject.Inject
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.transaction.Transactional


@EnableAutoWeld
@AddPackages(CustomerQueryGatewayImpl::class, CustomerConverter::class)
@Transactional
//@TransactionalQuarkusTest
class CustomerQueryGatewayImplTest {

    @Inject
    lateinit var gateway: CustomerQueryGateway

    @PersistenceContext
    lateinit var entityManager: EntityManager


    @Test fun findAll_ShouldReturnResults() {
        val result = gateway.findAll()
        assertEquals("Eleanor", result.first().firstName)
    }
}
