package spring.payment.payment.adapter.out.persistent.repository

import reactor.core.publisher.Mono
import spring.payment.payment.domain.PaymentEvent

interface PaymentRepository {

    fun save(paymentEvent: PaymentEvent): Mono<Void>
}