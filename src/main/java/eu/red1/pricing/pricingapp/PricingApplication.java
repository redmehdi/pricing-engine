package eu.red1.pricing.pricingapp;

import eu.red1.pricing.pricingapp.adapter.out.persistence.PriceRepository;
import eu.red1.pricing.pricingapp.domain.Price;
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
  public CommandLineRunner loadData(PriceRepository priceRepository) {
    return args -> {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

      priceRepository.save(new Price(
          1L,
          LocalDateTime.parse("2020-06-14 00:00:00", formatter),
          LocalDateTime.parse("2020-12-31 23:59:59", formatter),
          1,
          35455,
          0,
          35.50,
          "EUR"
      ));

      priceRepository.save(new Price(
          1L,
          LocalDateTime.parse("2020-06-14 15:00:00", formatter),
          LocalDateTime.parse("2020-06-14 18:30:00", formatter),
          2,
          35455,
          1,
          25.45,
          "EUR"
      ));

      priceRepository.save(new Price(
          1L,
          LocalDateTime.parse("2020-06-15 00:00:00", formatter),
          LocalDateTime.parse("2020-06-15 11:00:00", formatter),
          3,
          35455,
          1,
          30.50,
          "EUR"
      ));

      priceRepository.save(new Price(
          1L,
          LocalDateTime.parse("2020-06-15 16:00:00", formatter),
          LocalDateTime.parse("2020-12-31 23:59:59", formatter),
          4,
          35455,
          1,
          38.95,
          "EUR"
      ));
    };
  }
}