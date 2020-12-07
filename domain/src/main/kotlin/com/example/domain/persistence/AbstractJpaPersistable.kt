package com.example.domain.persistence

import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass
import java.io.Serializable
import javax.persistence.GenerationType

@MappedSuperclass
abstract class AbstractJpaPersistable<T : Serializable> {

    companion object {
        private val serialVersionUID = -5554308939380869754L
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idgen")
    var id: T? = null

    override fun equals(other: Any?): Boolean {
        other ?: return false

        if (this === other) return true

        if (javaClass != other.javaClass) return false

        other as AbstractJpaPersistable<*>

        return if (null == this.id) false else this.id == other.id
    }

    override fun hashCode(): Int {
        // @todo: would implementing non-static hashCode improve performance somehow?
        // https://kotlinexpertise.com/hibernate-with-kotlin-spring-boot/
        return 31
    }

    override fun toString() = "Entity of type ${this.javaClass.name} with id: $id"

}