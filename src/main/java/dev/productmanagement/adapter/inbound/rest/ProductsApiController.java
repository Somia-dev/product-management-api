package dev.productmanagement.adapter.inbound.rest;

import dev.productmanagement.adapter.ProductsApi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductsApiController implements ProductsApi {
    private final ProductsQueryUseCase productsQueryUseCase;
    private final ProductsCommandUseCase productsCommandUseCase;
    private final ProductMapper productMapper;

    public ProductsApiController(
            ProductsQueryUseCase productsQueryUseCase,
            ProductsCommandUseCase productsCommandUseCase,
            ProductMapper productMapper) {
        this.productsQueryUseCase = productsQueryUseCase;
        this.productsCommandUseCase = productsCommandUseCase;
        this.productMapper = productMapper;
    }

}
