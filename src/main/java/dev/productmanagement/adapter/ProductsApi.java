package dev.productmanagement.adapter;

import org.springframework.http.ResponseEntity;

public interface ProductsApi {

    ResponseEntity<ProductOutput> createOrUpdateProduct(String productId, @Valid ProductInput productinput);

    ResponseEntity<Void> deleteProduct(String productId);

    ResponseEntity<ProductOutput> editProductDescription(String productId, @Valid ProductDescriptionInput input);

    ResponseEntity<ProductOutput> getProductById(String productId);

    ResponseEntity<List<ProductOutput>> getProducts();

}
