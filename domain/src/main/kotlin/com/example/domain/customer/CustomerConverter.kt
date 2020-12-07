package com.example.domain.customer

import com.example.domain.QuarkusMappingConfig
import com.example.port.dto.CustomerDTO
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers


@Mapper(config = QuarkusMappingConfig::class)
//@Mapper(componentModel = "cdi")
interface CustomerConverter {
    fun convertToDTO(customer: Customer): CustomerDTO
    fun convertToDTO(customers: List<Customer>): List<CustomerDTO>
}