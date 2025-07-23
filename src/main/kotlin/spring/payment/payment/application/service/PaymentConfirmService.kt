package spring.payment.payment.application.service

import reactor.core.publisher.Mono
import spring.payment.common.UseCase
import spring.payment.payment.application.port.`in`.PaymentConfirmCommand
import spring.payment.payment.application.port.`in`.PaymentConfirmUseCase
import spring.payment.payment.application.port.out.PaymentStatusUpdatePort
import spring.payment.payment.application.port.out.PaymentValidationPort
import spring.payment.payment.domain.PaymentConfrimationResult

@UseCase
class PaymentConfirmService (
    private val paymentStatusUpdatePort: PaymentStatusUpdatePort,
    private val paymentValidationPort: PaymentValidationPort
) : PaymentConfirmUseCase {

    override fun confirm(command: PaymentConfirmCommand): Mono<PaymentConfrimationResult> {
        paymentStatusUpdatePort.updatePaymentStatusToExecuting(command.orderId, command.paymentKey)
    }
}