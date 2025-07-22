package spring.payment.payment.adapter.out.web.product.client

import reactor.core.publisher.Flux
import spring.payment.payment.domain.Product

interface ProductClient {

    fun getProducts(cartId: Long, productIds: List<Long>): Flux<Product>
}