package eu.red1.pricing.pricingapp.adapter.out.persistence;

import eu.red1.pricing.pricingapp.application.port.out.PriceRepositoryPort;
import eu.red1.pricing.pricingapp.domain.Price;
import java.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PriceRepository extends JpaRepository<Price, Long>, PriceRepositoryPort {

  default List<Price> findPrices(Long brandId, int productId, LocalDateTime applicationDate) {
    return findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
        brandId, productId, applicationDate, applicationDate);
  }

  List<Price> findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
      Long brandId, int productId, LocalDateTime startDate, LocalDateTime endDate);

}
