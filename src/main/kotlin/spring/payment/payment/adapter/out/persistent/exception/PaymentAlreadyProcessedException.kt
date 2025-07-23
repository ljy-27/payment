package spring.payment.payment.adapter.out.persistent.exception

import spring.payment.payment.domain.PaymentStatus

class PaymentAlreadyProcessedException(
    val status: PaymentStatus,
    message: String
) : RuntimeException(message)