package cau.cau_be.roadmap.entity;

import cau.cau_be.common.entity.Order;
import cau.cau_be.job.entity.Job;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;

@Entity
public class Roadmap {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private final Long id;
  @OneToMany(mappedBy = "roadmap")
  private final List<Order> orders;
  @OneToOne
  @JoinColumn(name = "job_id", nullable = false)
  private Job job;

  protected Roadmap() {
    this(null, null, null);
  }

  public Roadmap(Long id, Job job, List<Order> orders) {
    this.id = id;
    this.job = job;
    this.orders = orders;
  }

  public List<Order> getOrders() {
    return orders;
  }
}
