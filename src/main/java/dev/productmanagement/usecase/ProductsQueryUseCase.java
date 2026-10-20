package dev.productmanagement.usecase;

import dev.productmanagement.domain.Product;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface ProductsQueryUseCase {
    Product getProductById(String productId);

    List<? extends Product> getAllProducts();

}
