package eu.red1.pricing.pricingapp.application.port.in;

import eu.red1.pricing.pricingapp.domain.Price;
import java.time.LocalDateTime;

public interface GetPriceUseCase {
    Price getPrice(LocalDateTime applicationDate, int productId, Long brandId);
}
