package eu.red1.pricing.pricingapp.adapter.in.rest;

import eu.red1.pricing.pricingapp.adapter.in.rest.dto.PriceResponseDto;
import eu.red1.pricing.pricingapp.application.port.in.GetPriceUseCase;
import eu.red1.pricing.pricingapp.adapter.in.rest.dto.PricingRequestDto;
import eu.red1.pricing.pricingapp.application.port.in.PriceDTO;
import eu.red1.pricing.pricingapp.application.service.PriceMapper;
import eu.red1.pricing.pricingapp.domain.Price;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/api/price")
public class PricingController {

  private final GetPriceUseCase getPriceUseCase;

  public PricingController(final GetPriceUseCase getPriceUseCase) {
    this.getPriceUseCase = getPriceUseCase;
  }

  /**
   * Retrieves the highest priority price for a given product, brand, and application date.
   *
   * @param requestDto contains applicationDate, productId, and brandId.
   * @return Price details if found, or a 404 status if no applicable price exists.
   */
  @GetMapping
  public ResponseEntity<PriceResponseDto> getPrice(@Valid @RequestBody PricingRequestDto requestDto) {
    return getPriceUseCase.getPrice(
            requestDto.applicationDate(),
            requestDto.productId(),
            requestDto.brandId()
        ).map(PriceMapper::toResponseDTO).map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }
}