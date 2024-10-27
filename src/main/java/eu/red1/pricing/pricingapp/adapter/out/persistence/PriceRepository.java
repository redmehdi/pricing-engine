package eu.red1.pricing.pricingapp.adapter.out.persistence;

import eu.red1.pricing.pricingapp.application.port.out.PriceRepositoryPort;
import eu.red1.pricing.pricingapp.domain.Price;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PriceRepository extends JpaRepository<Price, Long>, PriceRepositoryPort {

  @Query("SELECT p FROM Price p WHERE p.brand.brandId = :brandId AND p.product.id = :productId "
      + "AND :applicationDate BETWEEN p.startDate AND p.endDate AND p.priority = (SELECT MAX(pri.priority) FROM Price pri WHERE pri.brand.brandId = :brandId AND "
      + "pri.product.id = :productId AND :applicationDate BETWEEN pri.startDate AND pri.endDate)")
  Optional<Price> findHighestPriorityPrice(
      @Param("brandId") Long brandId,
      @Param("productId") int productId,
      @Param("applicationDate") LocalDateTime applicationDate
  );
}