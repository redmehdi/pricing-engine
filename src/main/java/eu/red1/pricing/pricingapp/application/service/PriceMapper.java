package eu.red1.pricing.pricingapp.application.service;

import eu.red1.pricing.pricingapp.adapter.in.rest.dto.PriceResponseDto;
import eu.red1.pricing.pricingapp.application.port.in.PriceDTO;
import eu.red1.pricing.pricingapp.domain.Brand;
import eu.red1.pricing.pricingapp.domain.Price;
import eu.red1.pricing.pricingapp.domain.Product;

public class PriceMapper {

  public static PriceDTO toDTO(Price price) {
    return new PriceDTO(
        price.getStartDate(),
        price.getEndDate(),
        price.getPriceList(),
        price.getPriority(),
        price.getPrice(),
        price.getCurrency(),
        price.getBrand().getBrandId(),
        price.getProduct().getId()
    );
  }

  public static Price toEntity(PriceDTO priceDTO, Brand brand, Product product) {
    return new Price(
        priceDTO.getStartDate(),
        priceDTO.getEndDate(),
        priceDTO.getPriceList(),
        product,
        priceDTO.getPriority(),
        priceDTO.getPrice(),
        priceDTO.getCurrency(),
        brand
    );
  }

  public static PriceResponseDto toResponseDTO(PriceDTO priceDTO) {
    return new PriceResponseDto(
        priceDTO.getStartDate(),
        priceDTO.getEndDate(),
        priceDTO.getPriceList(),
        priceDTO.getPrice(),
        priceDTO.getCurrency(),
        priceDTO.getBrandId(),
        priceDTO.getProductId()
    );
  }
}
