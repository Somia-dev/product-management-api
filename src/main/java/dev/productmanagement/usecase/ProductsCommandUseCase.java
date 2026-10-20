package dev.productmanagement.usecase;

import dev.productmanagement.domain.Product;
import dev.productmanagement.usecase.dto.CreatedProduct;

public interface ProductsCommandUseCase {
    CreatedProduct createProduct(Product product);

    void deleteProduct(String productId);

    Product updateProductDescription(String productId, String description);

}
