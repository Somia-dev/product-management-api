package dev.productmanagement.usercase;

import dev.productmanagement.adapter.domain.Product;

public interface ProductQueryUserCase {
    Product getProductById(String productId);

    List<? extends Product> getAllProducts();

}
