package com.example.persistence.cfg

import org.hibernate.boot.model.naming.*

class CustomImplicitNamingStrategy : ImplicitNamingStrategyJpaCompliantImpl() {
    fun transformEntityNameWithPrefix(entityNaming: EntityNaming): String {
        val module = entityNaming.className
                .removePrefix("com.example.domain.")
                .split('.').dropLast(1).firstOrNull()
        return if (module == null)
            transformEntityName(entityNaming)
        else module + "_" + transformEntityName(entityNaming)
    }

    override fun determinePrimaryTableName(source: ImplicitEntityNameSource): Identifier? {
        val tableName = transformEntityNameWithPrefix(source.entityNaming)
        return toIdentifier(tableName, source.buildingContext)
    }

    override fun determineJoinTableName(source: ImplicitJoinTableNameSource): Identifier? {
        val name = (transformEntityNameWithPrefix(source.owningEntityNaming)
                + '_'
                + transformEntityName(source.nonOwningEntityNaming))
        return toIdentifier(name, source.buildingContext)
    }

    override fun determineCollectionTableName(source: ImplicitCollectionTableNameSource): Identifier? {
        val entityName = transformEntityNameWithPrefix(source.owningEntityNaming)
        val name = (entityName
                + '_'
                + transformAttributePath(source.owningAttributePath))
        return toIdentifier(name, source.buildingContext)
    }
}