package spring.payment.payment.adapter.`in`.web.view

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import reactor.core.publisher.Mono
import spring.payment.common.WebAdapter

@Controller
@WebAdapter
class CheckoutController {

    @GetMapping("/")
    fun checkoutPage(): Mono<String> {
        return Mono.just("checkout")
    }
}