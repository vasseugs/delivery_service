package rest;

import com.example.orders.model.Product;
import initializer.AbstractRestTest;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.jdbc.Sql;

@Sql(scripts = {
    "classpath:/sql/truncate_all_procedure_call.sql",
    "classpath:/sql/products.sql"
})
public class ProductRestTest extends AbstractRestTest {

  @Test
  void getAllAvailableProducts() {
    var allAvailableProducts = testRestTemplate.exchange(
        "/products/all",
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<List<Product>>() {}
    );

    Assertions.assertThat(allAvailableProducts.getStatusCode()).isEqualTo(HttpStatus.OK);
    Assertions.assertThat(allAvailableProducts.getBody()).hasSize(1);
  }
}
