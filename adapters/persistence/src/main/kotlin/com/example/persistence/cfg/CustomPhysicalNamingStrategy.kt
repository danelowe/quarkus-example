package com.example.persistence.cfg

import org.hibernate.boot.model.naming.Identifier
import org.hibernate.boot.model.naming.PhysicalNamingStrategy
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment
import java.util.*

class CustomPhysicalNamingStrategy : PhysicalNamingStrategy {
    override fun toPhysicalCatalogName(identifier: Identifier?, jdbcEnv: JdbcEnvironment?): Identifier? {
        return if (identifier == null) null else convertToSnakeCase(identifier)
    }

    override fun toPhysicalSchemaName(identifier: Identifier?, jdbcEnv: JdbcEnvironment?): Identifier? {
        return if (identifier == null) null else convertToSnakeCase(identifier)
    }

    override fun toPhysicalColumnName(identifier: Identifier, jdbcEnv: JdbcEnvironment?): Identifier {
        return convertToSnakeCase(identifier)
    }

    override fun toPhysicalSequenceName(identifier: Identifier, jdbcEnv: JdbcEnvironment?): Identifier {
        return convertToSnakeCase(identifier)
    }

    override fun toPhysicalTableName(identifier: Identifier, jdbcEnv: JdbcEnvironment?): Identifier {
        return convertToSnakeCase(identifier)
    }

    private fun convertToSnakeCase(identifier: Identifier): Identifier {
        val buf = StringBuilder(identifier.text.replace('.', '_'))
        var i = 1
        while (i < buf.length - 1) {
            if (!Character.isUpperCase(buf.get(i - 1)) &&
                    (buf.get(i - 1) != '_') &&
                    Character.isUpperCase(buf.get(i)) &&
                    Character.isLowerCase(buf.get(i + 1))) {
                buf.insert(i++, '_')
            }
            i++
        }
        return Identifier.toIdentifier(buf.toString().toLowerCase(Locale.ROOT))
    }
}