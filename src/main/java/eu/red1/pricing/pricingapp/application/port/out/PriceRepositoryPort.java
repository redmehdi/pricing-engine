package eu.red1.pricing.pricingapp.application.port.out;

import eu.red1.pricing.pricingapp.domain.Price;
import java.time.LocalDateTime;
import java.util.List;


public interface PriceRepositoryPort {

  List<Price> findPrices(Long brandId, int productId, LocalDateTime applicationDate);
}
