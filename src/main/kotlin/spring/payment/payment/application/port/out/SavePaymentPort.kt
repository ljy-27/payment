package spring.payment.payment.application.port.out

import reactor.core.publisher.Mono
import spring.payment.payment.domain.PaymentEvent

interface SavePaymentPort {

    fun save(paymentEvent: PaymentEvent): Mono<Void>
}