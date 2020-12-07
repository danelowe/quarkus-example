package com.example.domain.customer

import javax.persistence.*

@Entity
@SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "customer_customer_id_seq")
class Customer protected constructor() {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idgen")
    var id: Int? = null

    lateinit var firstName: String
    lateinit var lastName: String

    override fun toString(): String {
        return String.format("Customer[id=%d, firstName='%s', lastName='%s']", id,
                firstName, lastName)
    }

    companion object {
        fun new(firstName: String, lastName: String) : Customer {
            val e = Customer()
            e.firstName = firstName
            e.lastName = lastName
            return e
        }
    }
}