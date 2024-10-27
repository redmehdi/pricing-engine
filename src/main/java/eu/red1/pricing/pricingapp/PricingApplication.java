package eu.red1.pricing.pricingapp;

import eu.red1.pricing.pricingapp.adapter.out.persistence.BrandRepository;
import eu.red1.pricing.pricingapp.adapter.out.persistence.PriceRepository;
import eu.red1.pricing.pricingapp.adapter.out.persistence.ProductRepository;
import eu.red1.pricing.pricingapp.domain.Brand;
import eu.red1.pricing.pricingapp.domain.Price;
import eu.red1.pricing.pricingapp.domain.Product;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PricingApplication {

  public static void main(String[] args) {
    SpringApplication.run(PricingApplication.class, args);
  }

  @Bean
  public CommandLineRunner loadData(BrandRepository brandRepository,
      PriceRepository priceRepository, ProductRepository productRepository) {
    return args -> {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

      // Insert data into BRANDS table
      Brand zara = new Brand(1L, "ZARA");
      brandRepository.save(zara);

      // Insert data into PRODUCTS table
      Product product = new Product();
      product.setId(35455L);
      product.setProductName("Sample Product");
      productRepository.save(product);


      // Insert data into PRICES table, associating each entry with the Brand and Product
      priceRepository.save(new Price(
          LocalDateTime.parse("2020-06-14 00:00:00", formatter),
          LocalDateTime.parse("2020-12-31 23:59:59", formatter),
          1, product, 0, 35.50, "EUR", zara
      ));
      priceRepository.save(new Price(
          LocalDateTime.parse("2020-06-14 15:00:00", formatter),
          LocalDateTime.parse("2020-06-14 18:30:00", formatter),
          2, product, 1, 25.45, "EUR", zara
      ));
      priceRepository.save(new Price(
          LocalDateTime.parse("2020-06-15 00:00:00", formatter),
          LocalDateTime.parse("2020-06-15 11:00:00", formatter),
          3, product, 1, 30.50, "EUR", zara
      ));
      priceRepository.save(new Price(
          LocalDateTime.parse("2020-06-15 16:00:00", formatter),
          LocalDateTime.parse("2020-12-31 23:59:59", formatter),
          4, product, 1, 38.95, "EUR", zara
      ));
    };
  }
}