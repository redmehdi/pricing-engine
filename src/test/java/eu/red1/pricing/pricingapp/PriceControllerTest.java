package eu.red1.pricing.pricingapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

  /**
  @Test
  public void testCase1() throws Exception {
    LocalDateTime applicationDate = LocalDateTime.parse("2020-06-14T10:00:00", formatter);
    int productId = 35455;
    int brandId = 1;

    MvcResult result = mockMvc.perform(get("/api/price")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"applicationDate\":\"" + applicationDate + "\", \"productId\":" + productId + ", \"brandId\":" + brandId + "}"))
        .andExpect(status().isOk())
        .andReturn();

    // Deserialize response
    PriceResponseDto response = objectMapper.readValue(result.getResponse().getContentAsString(), PriceResponseDto.class);

    // Assert the expected output
    assertEquals(productId, response.getProductId());
    assertEquals(brandId, response.getBrandId());
    assertEquals(1, response.getPriceList());
    assertEquals(35.50, response.getPrice());
  }

  @Test
  public void testCase2() throws Exception {
    LocalDateTime applicationDate = LocalDateTime.parse("2020-06-14T16:00:00", formatter);
    int productId = 35455;
    int brandId = 1;

    MvcResult result = mockMvc.perform(get("/api/price")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"applicationDate\":\"" + applicationDate + "\", \"productId\":" + productId + ", \"brandId\":" + brandId + "}"))
        .andExpect(status().isOk())
        .andReturn();

    PriceResponseDto response = objectMapper.readValue(result.getResponse().getContentAsString(), PriceResponseDto.class);

    assertEquals(productId, response.getProductId());
    assertEquals(brandId, response.getBrandId());
    assertEquals(2, response.getPriceList());
    assertEquals(25.45, response.getPrice());
  }

  @Test
  public void testCase3() throws Exception {
    LocalDateTime applicationDate = LocalDateTime.parse("2020-06-14T21:00:00", formatter);
    int productId = 35455;
    int brandId = 1;

    MvcResult result = mockMvc.perform(get("/api/price")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"applicationDate\":\"" + applicationDate + "\", \"productId\":" + productId + ", \"brandId\":" + brandId + "}"))
        .andExpect(status().isOk())
        .andReturn();

    PriceResponseDto response = objectMapper.readValue(result.getResponse().getContentAsString(), PriceResponseDto.class);

    assertEquals(productId, response.getProductId());
    assertEquals(brandId, response.getBrandId());
    assertEquals(1, response.getPriceList());
    assertEquals(35.50, response.getPrice());
  }

  @Test
  public void testCase4() throws Exception {
    LocalDateTime applicationDate = LocalDateTime.parse("2020-06-15T10:00:00", formatter);
    int productId = 35455;
    int brandId = 1;

    MvcResult result = mockMvc.perform(get("/api/price")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"applicationDate\":\"" + applicationDate + "\", \"productId\":" + productId + ", \"brandId\":" + brandId + "}"))
        .andExpect(status().isOk())
        .andReturn();

    PriceResponseDto response = objectMapper.readValue(result.getResponse().getContentAsString(), PriceResponseDto.class);

    assertEquals(productId, response.getProductId());
    assertEquals(brandId, response.getBrandId());
    assertEquals(3, response.getPriceList());
    assertEquals(30.50, response.getPrice());
  }

  @Test
  public void testCase5() throws Exception {
    LocalDateTime applicationDate = LocalDateTime.parse("2020-06-16T21:00:00", formatter);
    int productId = 35455;
    int brandId = 1;

    MvcResult result = mockMvc.perform(get("/api/price")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"applicationDate\":\"" + applicationDate + "\", \"productId\":" + productId + ", \"brandId\":" + brandId + "}"))
        .andExpect(status().isOk())
        .andReturn();

    PriceResponseDto response = objectMapper.readValue(result.getResponse().getContentAsString(), PriceResponseDto.class);

    assertEquals(productId, response.getProductId());
    assertEquals(brandId, response.getBrandId());
    assertEquals(4, response.getPriceList());
    assertEquals(38.95, response.getPrice());
  }*/
}