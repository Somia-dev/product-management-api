package dev.productmanagement.adapter.inbound.rest.dto;

import dev.productmanagement.domain.Product;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ProductInput(
        @NotBlank @Size(min = 3, max = 255) @JsonProperty("name") String name,
        @NotBlank @Size(min = 10, max = 255) @JsonProperty("description") String description,
        @NotNull @Positive @JsonProperty("price") BigDecimal price) {

    public Product toProduct(String sku) {
        return new Product(name, description, sku, price);
    }

}
