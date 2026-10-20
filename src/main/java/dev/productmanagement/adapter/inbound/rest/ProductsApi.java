package dev.productmanagement.adapter.inbound.rest;

import dev.productmanagement.adapter.inbound.rest.dto.ProductDescriptionInput;
import dev.productmanagement.adapter.inbound.rest.dto.ProductInput;
import dev.productmanagement.adapter.inbound.rest.dto.ProductOutput;
import dev.productmanagement.adapter.inbound.rest.validation.ValidSku;

import java.util.List;

import org.springframework.http.ResponseEntity;

import jakarta.validation.Valid;

public interface ProductsApi {

    ResponseEntity<ProductOutput> createOrUpdateProduct(@ValidSku String productId, @Valid ProductInput productinput);

    ResponseEntity<Void> deleteProduct(@ValidSku String productId);

    ResponseEntity<ProductOutput> editProductDescription(@ValidSku String productId,
            @Valid ProductDescriptionInput input);

    ResponseEntity<ProductOutput> getProductById(@ValidSku String productId);

    ResponseEntity<List<ProductOutput>> getProducts();

}
