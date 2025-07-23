package spring.payment.payment.adapter.out.persistent

import reactor.core.publisher.Mono
import spring.payment.common.PersistentAdapter
import spring.payment.payment.adapter.out.persistent.repository.PaymentRepository
import spring.payment.payment.adapter.out.persistent.repository.PaymentStatusUpdateRepository
import spring.payment.payment.application.port.out.PaymentStatusUpdatePort
import spring.payment.payment.application.port.out.PaymentValidationPort
import spring.payment.payment.application.port.out.SavePaymentPort
import spring.payment.payment.domain.PaymentEvent

@PersistentAdapter
class PaymentPersistentAdapter(
    private val paymentRepository: PaymentRepository,
    private val paymentStatusUpdateRepository: PaymentStatusUpdateRepository
) : SavePaymentPort, PaymentStatusUpdatePort, PaymentValidationPort {

    override fun save(paymentEvent: PaymentEvent): Mono<Void> {
        return paymentRepository.save(paymentEvent)
    }

    override fun updatePaymentStatusToExecuting(orderId: String, paymentKey: String): Mono<Boolean> {
        return paymentStatusUpdateRepository.updatePaymentStatusToExecuting(orderId, paymentKey)
    }

    override fun isValid(orderId: String, amount: Long): Mono<Boolean> {
        TODO("Not yet implemented")
    }
}