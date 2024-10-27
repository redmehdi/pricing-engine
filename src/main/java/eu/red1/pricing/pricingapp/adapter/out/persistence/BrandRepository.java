package eu.red1.pricing.pricingapp.adapter.out.persistence;

import eu.red1.pricing.pricingapp.domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {

}
