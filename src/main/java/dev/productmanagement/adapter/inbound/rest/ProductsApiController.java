package dev.productmanagement.adapter.inbound.rest;

import dev.productmanagement.adapter.inbound.rest.dto.ProductDescriptionInput;
import dev.productmanagement.adapter.inbound.rest.dto.ProductInput;
import dev.productmanagement.adapter.inbound.rest.dto.ProductOutput;
import dev.productmanagement.usecase.ProductsCommandUseCase;
import dev.productmanagement.usecase.ProductsQueryUseCase;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Validated
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

    @PutMapping(value = "/{productId}")
    @Override
    public ResponseEntity<ProductOutput> createOrUpdateProduct(
            @PathVariable("productId") String productId,
            @RequestBody ProductInput productInput) {
        final var product = productsCommandUseCase.createProduct(productInput.toProduct(productId));
        HttpStatus status = product.isNewProduct() ? HttpStatus.CREATED : HttpStatus.OK;
        return ResponseEntity.status(status)
                .body(productMapper.toProductOutput(product.product()));

    }

    @GetMapping
    @Override
    public ResponseEntity<List<ProductOutput>> getProducts() {
        final var products = productsQueryUseCase.getAllProducts();
        final var outputs = products.stream()
                .map(productMapper::toProductOutput)
                .toList();
        return ResponseEntity.ok(outputs);
    }

    @GetMapping("/{productId}")
    @Override
    public ResponseEntity<ProductOutput> getProductById(
            @PathVariable("productId") String productId) {
        final var product = productsQueryUseCase.getProductById(productId);
        return ResponseEntity.ok(productMapper.toProductOutput(product));
    }

    @PatchMapping("/{productId}/description")
    @Override
    public ResponseEntity<ProductOutput> editProductDescription(
            @PathVariable("productId") String productId,
            @RequestBody ProductDescriptionInput input) {
        final var product = productsCommandUseCase.updateProductDescription(productId, input.description());
        return ResponseEntity.ok(productMapper.toProductOutput(product));
    }

    @DeleteMapping("/{productId}")
    @Override
    public ResponseEntity<Void> deleteProduct(
            @PathVariable("productId") String productId) {
        productsCommandUseCase.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }

}
