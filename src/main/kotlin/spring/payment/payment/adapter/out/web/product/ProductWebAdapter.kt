package spring.payment.payment.adapter.out.web.product

import reactor.core.publisher.Flux
import spring.payment.common.WebAdapter
import spring.payment.payment.adapter.out.web.product.client.ProductClient
import spring.payment.payment.application.port.out.LoadProductPort
import spring.payment.payment.domain.Product

@WebAdapter
class ProductWebAdapter(
    private val productClient: ProductClient
) : LoadProductPort {

    override fun getProducts(cartId: Long, productIds: List<Long>): Flux<Product> {
        return productClient.getProducts(cartId, productIds)
    }
}