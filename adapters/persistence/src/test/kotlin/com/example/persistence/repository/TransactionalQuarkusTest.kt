package com.example.persistence.repository

import io.quarkus.test.junit.QuarkusTest
import javax.enterprise.inject.Stereotype
import javax.interceptor.InterceptorBinding
import javax.transaction.Transactional


@QuarkusTest
@Stereotype
@InterceptorBinding()
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS, AnnotationTarget.TYPE)
@Transactional
annotation class TransactionalQuarkusTest