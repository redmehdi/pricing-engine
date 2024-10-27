package eu.red1.pricing.pricingapp.adapter.in.rest.dto;

import java.time.LocalDateTime;

public record PriceResponseDto(
    LocalDateTime startDate,
    LocalDateTime endDate,
    int priceList,
    double price,
    String currency,
    Long brandId,
    Long productId
) {
}