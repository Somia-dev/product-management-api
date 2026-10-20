package dev.productmanagement.adapter.inbound.rest.dto;

import jakarta.validation.constraints.NotBlank;

public record ProductDescriptionInput(@NotBlank String description) {

}
