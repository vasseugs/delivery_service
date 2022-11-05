package com.example.orders.entity;

import com.example.orders.model.OrderItem;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_items")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "order_id")
  private Long orderId;

  @OneToOne
  @JoinColumn(name = "product_name", referencedColumnName = "name")
  private ProductEntity product;

  @Column(name = "amount")
  private Integer amount;

  public OrderItem toOrderItem() {
    return new OrderItem(this.product.toProduct(), this.amount);
  }
}
