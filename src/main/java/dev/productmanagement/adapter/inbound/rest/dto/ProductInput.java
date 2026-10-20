package dev.productmanagement.adapter.inbound.rest.dto;

import java.math.BigDecimal;

import dev.productmanagement.domain.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductInput(
        @NotBlank String name,
        String description,
        @NotNull @Positive BigDecimal price) {

    public Product toProduct(String sku) {
        return new Product(name, description, sku, price);
    }

}
