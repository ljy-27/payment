package spring.payment.payment.application.port.out

import reactor.core.publisher.Flux
import spring.payment.payment.domain.Product

interface LoadProductPort {

    fun getProducts(cartId: Long, productIds: List<Long>): Flux<Product>
}