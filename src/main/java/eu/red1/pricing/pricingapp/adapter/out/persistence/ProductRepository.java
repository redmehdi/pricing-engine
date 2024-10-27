package eu.red1.pricing.pricingapp.adapter.out.persistence;

import eu.red1.pricing.pricingapp.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
