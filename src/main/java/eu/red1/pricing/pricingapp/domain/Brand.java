package eu.red1.pricing.pricingapp.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BRANDS")
public class Brand {
  @Id
  private Long brandId;
  private String brandName;

  @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Price> prices;
  // Getters and Setters

  public Long getBrandId() {
    return brandId;
  }

  public void setBrandId(Long brandId) {
    this.brandId = brandId;
  }

  public String getBrandName() {
    return brandName;
  }

  public void setBrandName(String brandName) {
    this.brandName = brandName;
  }

  public List<Price> getPrices() {
    return prices;
  }

  public void setPrices(List<Price> prices) {
    this.prices = prices;
  }
  // Constructors

  public Brand() {
    this.prices = new ArrayList<>();
  }

  public Brand(Long brandId, String brandName) {
    this.brandId = brandId;
    this.brandName = brandName;
    this.prices = new ArrayList<>();
  }
}

