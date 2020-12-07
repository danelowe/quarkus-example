package com.example.persistence.repository

import com.arjuna.ats.jta.logging.jtaLogger
import io.quarkus.narayana.jta.runtime.interceptor.RunnableWithException
import io.quarkus.narayana.jta.runtime.interceptor.TransactionalInterceptorRequired
import javax.annotation.Priority
import javax.interceptor.AroundInvoke
import javax.interceptor.Interceptor
import javax.interceptor.InvocationContext
import javax.transaction.Transaction
import javax.transaction.TransactionManager
import javax.transaction.Transactional


/**
 * @author paul.robinson@redhat.com 25/05/2013
 */
@Interceptor
@TransactionalQuarkusTest
@Priority(Interceptor.Priority.PLATFORM_BEFORE)
class TransactionalInterceptorRequired : TransactionalInterceptorRequired() {
    @AroundInvoke
    @Throws(Exception::class)
    override fun intercept(ic: InvocationContext?): Any? {
        return super.intercept(ic)
    }

    override fun endTransaction(tm: TransactionManager, tx: Transaction, afterEndTransaction: RunnableWithException) {
        if (tx != tm.getTransaction()) {
            throw RuntimeException(jtaLogger.i18NLogger.get_wrong_tx_on_thread());
        }
        tm.rollback()
        afterEndTransaction.run();
    }
}