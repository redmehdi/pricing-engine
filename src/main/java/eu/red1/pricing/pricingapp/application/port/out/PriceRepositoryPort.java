package eu.red1.pricing.pricingapp.application.port.out;

import eu.red1.pricing.pricingapp.domain.Price;
import java.time.LocalDateTime;
import java.util.Optional;


public interface PriceRepositoryPort {

  Optional<Price> findHighestPriorityPrice(Long brandId, Long productId,
      LocalDateTime applicationDate);
}
