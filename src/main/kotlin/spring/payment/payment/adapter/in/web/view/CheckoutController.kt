package spring.payment.payment.adapter.`in`.web.view

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import reactor.core.publisher.Mono
import spring.payment.common.IdempotencyCreator
import spring.payment.common.WebAdapter
import spring.payment.payment.adapter.`in`.web.request.CheckoutRequest
import spring.payment.payment.application.port.`in`.CheckoutCommand
import spring.payment.payment.application.port.`in`.CheckoutUseCase

@WebAdapter
@Controller
class CheckoutController (
    private val checkoutUseCase: CheckoutUseCase
) {

    @GetMapping("/")
    fun checkoutPage(request: CheckoutRequest, model: Model): Mono<String> {
        val command = CheckoutCommand(
            cartId = request.cartId,
            buyerId = request.buyerId,
            productIds = request.productIds,
            idempotencyKey = IdempotencyCreator.create(request.seed)
        )

        return checkoutUseCase.checkout(command)
            .map {
                model.addAttribute("orderId", it.orderId)
                model.addAttribute("orderName", it.orderName)
                model.addAttribute("amount", it.amount)
                "checkout"
            }
    }
}