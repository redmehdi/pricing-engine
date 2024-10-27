package eu.red1.pricing.pricingapp.application.port.in;

import java.time.LocalDateTime;

public class PriceDTO {

  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private int priceList;
  private int priority;
  private double price;
  private String currency;
  private Long brandId;
  private Long productId;

  public PriceDTO(LocalDateTime startDate, LocalDateTime endDate, int priceList, int priority,
      double price, String currency, Long brandId, Long productId) {
    this.startDate = startDate;
    this.endDate = endDate;
    this.priceList = priceList;
    this.priority = priority;
    this.price = price;
    this.currency = currency;
    this.brandId = brandId;
    this.productId = productId;
  }

  public LocalDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDateTime startDate) {
    this.startDate = startDate;
  }

  public LocalDateTime getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDateTime endDate) {
    this.endDate = endDate;
  }

  public int getPriceList() {
    return priceList;
  }

  public void setPriceList(int priceList) {
    this.priceList = priceList;
  }

  public int getPriority() {
    return priority;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public Long getBrandId() {
    return brandId;
  }

  public void setBrandId(Long brandId) {
    this.brandId = brandId;
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }
}
