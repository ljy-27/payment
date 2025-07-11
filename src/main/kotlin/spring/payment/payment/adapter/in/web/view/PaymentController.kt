package spring.payment.payment.adapter.`in`.web.view

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import reactor.core.publisher.Mono
import spring.payment.common.WebAdapter

@Controller
@WebAdapter
class PaymentController {

    @GetMapping("/success")
    fun sucessPage(): Mono<String> {
        return Mono.just("success")
    }

    @GetMapping("/fail")
    fun failPage(): Mono<String> {
        return Mono.just("fail")
    }
}