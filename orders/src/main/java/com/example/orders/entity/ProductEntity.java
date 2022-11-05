package com.example.orders.entity;

import com.example.orders.model.Product;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents anything that can be ordered - food, drinks etc.
 */

@Entity
@Table(name = "products")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductEntity {

  @Id
  @Column(name = "name")
  private String name;

  @Column(name = "cost")
  private BigDecimal cost;

  public Product toProduct() {
    return new Product(this.name, this.cost);
  }
}
