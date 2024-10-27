package eu.red1.pricing.pricingapp.adapter.in.rest.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import java.time.LocalDateTime;

public record PricingRequestDto(
    @NotNull(message = "Application date is required")
    @PastOrPresent(message = "Application date cannot be in the future")
    LocalDateTime applicationDate,

    @Positive(message = "Product ID must be a positive number")
    Long productId,

    @NotNull(message = "Brand ID is required")
    @Positive(message = "Brand ID must be a positive number")
    Long brandId
) {}
