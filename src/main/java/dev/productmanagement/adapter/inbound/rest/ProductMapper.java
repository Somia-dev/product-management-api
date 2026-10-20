package dev.productmanagement.adapter.inbound.rest;

import org.springframework.stereotype.Component;

import dev.productmanagement.adapter.inbound.rest.dto.ProductOutput;
import dev.productmanagement.domain.Product;

@Component
public class ProductMapper {

    public ProductOutput toProductOutput(Product product) {
        return new ProductOutput(
                product.getSku(),
                product.getName(),
                product.getDescription(),
                product.getPrice());
    }
}
