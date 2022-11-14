package initializer;

import com.example.orders.OrdersApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.lang.NonNull;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
import initializer.AbstractRestTest.PostgresContainerInitializer;

@SpringBootTest(classes = OrdersApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = {PostgresContainerInitializer.class})
@TestPropertySource(locations = "classpath:/application-test.properties")
@Testcontainers
public abstract class AbstractRestTest {

  @Autowired
  protected TestRestTemplate testRestTemplate;

  static class PostgresContainerInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    public static PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>("postgres:14")
        .withDatabaseName("orders")
        .withUsername("postgres")
        .withPassword("postgres");

    @Override
    public void initialize(@NonNull ConfigurableApplicationContext context) {
      postgresContainer.start();

      TestPropertyValues.of(
          "spring.datasource.url=" + postgresContainer.getJdbcUrl(),
          "spring.datasource.username=" + postgresContainer.getUsername(),
          "spring.datasource.password=" + postgresContainer.getPassword()
      ).applyTo(context);
    }
  }
}
