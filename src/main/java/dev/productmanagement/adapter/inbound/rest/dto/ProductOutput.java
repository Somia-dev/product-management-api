package dev.productmanagement.adapter.inbound.rest.dto;

import java.math.BigDecimal;

public record ProductOutput(String sku, String name, String description, BigDecimal price) {

}
