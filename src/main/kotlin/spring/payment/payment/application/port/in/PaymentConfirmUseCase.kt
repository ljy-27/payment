package spring.payment.payment.application.port.`in`

import reactor.core.publisher.Mono
import spring.payment.payment.domain.PaymentConfrimationResult

interface PaymentConfirmUseCase {

    fun confirm(command: PaymentConfirmCommand): Mono<PaymentConfrimationResult>
}