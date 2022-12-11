package rest;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.orders.model.Order;
import com.example.orders.model.OrderItem;
import initializer.AbstractRestTest;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.jdbc.Sql;

@Sql(scripts = {
    "/sql/truncate_all_procedure_call.sql",
})
public class OrdersRestTest extends AbstractRestTest {

  @Test
  void createOrderAndGetById() {
    var userId = 1L;
    var items = List.of(
      new OrderItem(1L, 1),
      new OrderItem(2L, 2)
    );

    var order = Order.builder()
        .userId(userId)
        .items(items)
        .build();

    var createNewOrder = testRestTemplate.exchange(
        "/orders/create",
        HttpMethod.POST,
        new HttpEntity<>(order),
        Long.class
    );

    assertThat(createNewOrder.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(createNewOrder.getBody()).isNotNull();

    var orderId = createNewOrder.getBody();

    var getOrderById = testRestTemplate.exchange(
        "/orders/" + orderId,
        HttpMethod.GET,
        null,
        Order.class
    );

    assertThat(getOrderById.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(getOrderById.getBody()).isNotNull();

    assertThat(order.getUserId()).isEqualTo(userId);
    assertThat(order.getItems()).isEqualTo(items);
  }
}
