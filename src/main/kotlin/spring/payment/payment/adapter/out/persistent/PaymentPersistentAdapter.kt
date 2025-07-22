package spring.payment.payment.adapter.out.persistent

import reactor.core.publisher.Mono
import spring.payment.common.PersistentAdapter
import spring.payment.payment.adapter.out.persistent.repository.PaymentRepository
import spring.payment.payment.application.port.out.SavePaymentPort
import spring.payment.payment.domain.PaymentEvent

@PersistentAdapter
class PaymentPersistentAdapter(
    private val paymentRepository: PaymentRepository
) : SavePaymentPort {

    override fun save(paymentEvent: PaymentEvent): Mono<Void> {
        return paymentRepository.save(paymentEvent)
    }
}