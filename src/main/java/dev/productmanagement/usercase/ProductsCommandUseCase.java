package dev.productmanagement.usercase;

import dev.productmanagement.adapter.domain.Product;

public interface ProductsCommandUseCase {
    CreatedProduct createProduct(Product product);

    void deleteProduct(String productId);

    Product updateProductDescription(String productId, String description);

}
