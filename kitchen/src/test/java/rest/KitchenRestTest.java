package rest;

import com.example.kitchen.model.Dish;
import initializer.AbstractRestTest;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.jdbc.Sql;

@Sql(scripts = {
    "/sql/truncate_all_procedure_call.sql",
    "/sql/dishes.sql"
})
public class KitchenRestTest extends AbstractRestTest {

  @Test
  void getAllAvailableProducts() {
    var allAvailableProducts = testRestTemplate.exchange(
        "/kitchen/dishes/all",
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<List<Dish>>() {}
    );

    Assertions.assertThat(allAvailableProducts.getStatusCode()).isEqualTo(HttpStatus.OK);
    Assertions.assertThat(allAvailableProducts.getBody()).hasSize(1);
  }
}
