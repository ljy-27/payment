package spring.payment.payment.application.port.`in`

import reactor.core.publisher.Mono
import spring.payment.payment.domain.CheckoutResult

interface CheckoutUseCase {

    fun checkout(command: CheckoutCommand): Mono<CheckoutResult>
}