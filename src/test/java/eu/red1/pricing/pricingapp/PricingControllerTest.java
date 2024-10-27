package eu.red1.pricing.pricingapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PricingControllerTest {

  @Autowired
  private MockMvc mockMvc;

  private static final String API_URL = "/api/price";

  private String getRequestPayload(String applicationDate, int productId, Long brandId) {
    return """
        {
            "applicationDate": "%s",
            "productId": %d,
            "brandId": %d
        }
        """.formatted(applicationDate, productId, brandId);
  }

  private void performAndAssert(String applicationDate, int productId, Long brandId,
      double expectedPrice) throws Exception {
    String requestBody = getRequestPayload(applicationDate, productId, brandId);

    mockMvc.perform(get(API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.price").value(expectedPrice));
  }

  @Test
  public void testPriceAt10OnJune14() throws Exception {
    performAndAssert("2020-06-14T10:00:00", 35455, 1L, 35.50);
  }

  @Test
  public void testPriceAt16OnJune14() throws Exception {
    performAndAssert("2020-06-14T16:00:00", 35455, 1L, 25.45);
  }

  @Test
  public void testPriceAt21OnJune14() throws Exception {
    performAndAssert("2020-06-14T21:00:00", 35455, 1L, 35.50);
  }

  @Test
  public void testPriceAt10OnJune15() throws Exception {
    performAndAssert("2020-06-15T10:00:00", 35455, 1L, 30.50);
  }

  @Test
  public void testPriceAt21OnJune16() throws Exception {
    performAndAssert("2020-06-16T21:00:00", 35455, 1L, 38.95);
  }
}