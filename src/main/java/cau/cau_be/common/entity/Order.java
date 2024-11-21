package cau.cau_be.common.entity;

import cau.cau_be.roadmap.entity.Roadmap;
import cau.cau_be.tech.entity.Tech;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private final Long id;

  @Column(name = "order_number", nullable = false)
  private final int order;

  @ManyToOne
  @JoinColumn(name = "roadmap_id", nullable = false)
  private final Roadmap roadmap;

  @ManyToOne
  @JoinColumn(name = "tech_id", nullable = false)
  private final Tech tech;

  protected Order() {
    this(null, 0, null, null);
  }

  public Order(Long id, int order, Roadmap roadmap, Tech tech) {
    this.id = id;
    this.order = order;
    this.roadmap = roadmap;
    this.tech = tech;
  }

  public int getOrder() {
    return order;
  }

  public Tech getTech() {
    return tech;
  }
}
