package dev.productmanagement.usecase.dto;

import dev.productmanagement.domain.Product;

public record CreatedProduct(Product product, boolean isNewProduct) {

}
