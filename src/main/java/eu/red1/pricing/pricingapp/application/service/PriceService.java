package eu.red1.pricing.pricingapp.application.service;

import eu.red1.pricing.pricingapp.application.port.in.GetPriceUseCase;
import eu.red1.pricing.pricingapp.application.port.in.PriceDTO;
import eu.red1.pricing.pricingapp.application.port.out.PriceRepositoryPort;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PriceService implements GetPriceUseCase {

  private final PriceRepositoryPort priceRepositoryPort;

  public PriceService(PriceRepositoryPort priceRepositoryPort) {
    this.priceRepositoryPort = priceRepositoryPort;
  }

  @Override
  public Optional<PriceDTO> getPrice(LocalDateTime applicationDate, Long productId, Long brandId) {
    // Perform the query to retrieve the Price entity and map to PriceResponseDto
    return priceRepositoryPort.findHighestPriorityPrice(brandId, productId, applicationDate)
        .map(PriceMapper::toDTO);
  }
}