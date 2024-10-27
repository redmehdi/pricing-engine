package eu.red1.pricing.pricingapp.application.service;

import eu.red1.pricing.pricingapp.application.port.in.GetPriceUseCase;
import eu.red1.pricing.pricingapp.application.port.out.PriceRepositoryPort;
import eu.red1.pricing.pricingapp.domain.Price;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GetPriceService implements GetPriceUseCase {

    private final PriceRepositoryPort priceRepositoryPort;

    public GetPriceService(PriceRepositoryPort priceRepositoryPort) {
        this.priceRepositoryPort = priceRepositoryPort;
    }

    @Override
    public Price getPrice(LocalDateTime applicationDate, int productId, Long brandId) {
        List<Price> prices = priceRepositoryPort.findPrices(brandId, productId, applicationDate);
        return prices.stream()
                .max(Comparator.comparingInt(Price::getPriority))
                .orElse(null);
    }
}
