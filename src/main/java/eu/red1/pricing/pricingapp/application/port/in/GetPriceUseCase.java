package eu.red1.pricing.pricingapp.application.port.in;

import eu.red1.pricing.pricingapp.domain.Price;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface GetPriceUseCase {
    Optional<PriceDTO> getPrice(final LocalDateTime applicationDate, int productId, final Long brandId);
}