package com.example.orders.entity;

import com.example.orders.model.Order;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "user_id")
  private Long userId;

  @OneToMany(
      fetch = FetchType.EAGER
  )
  @JoinColumn(name = "order_id", referencedColumnName = "id")
  private List<OrderItemEntity> items;

  @Column(name = "created_at")
  private Timestamp createdAt;

  public Order toOrder() {
    return Order.builder()
        .userId(this.userId)
        .items(this.items.stream()
            .map(OrderItemEntity::toOrderItem)
            .collect(Collectors.toList()))
        .build();
  }
}
