package eu.red1.pricing.pricingapp.adapter.in.rest;

import eu.red1.pricing.pricingapp.application.port.in.GetPriceUseCase;
import eu.red1.pricing.pricingapp.common.PricingRequestDto;
import eu.red1.pricing.pricingapp.domain.Price;
import jakarta.validation.Valid;
import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PricingController {

    private final GetPriceUseCase getPriceUseCase;

    public PricingController(GetPriceUseCase getPriceUseCase) {
        this.getPriceUseCase = getPriceUseCase;
    }

    @GetMapping("/api/price")
    public Price getPrice(@Valid @RequestBody PricingRequestDto requestDto) {
        return getPriceUseCase.getPrice(requestDto.applicationDate(), requestDto.productId(), requestDto.brandId());
    }
}
