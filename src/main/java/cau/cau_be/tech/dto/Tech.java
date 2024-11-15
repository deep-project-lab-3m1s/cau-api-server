package cau.cau_be.tech.dto;

import cau.cau_be.common.entity.Order;
import cau.cau_be.common.entity.TechSubject;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Tech {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private final Long id;

  @Column(nullable = false)
  private final String name;

  @OneToMany(mappedBy = "tech", cascade = CascadeType.ALL, orphanRemoval = true)
  private final List<TechSubject> techSubjects;

  @OneToMany(mappedBy = "tech")
  private final List<Order> orders;

  protected Tech() {
    this(null, null, null, null);
  }

  public Tech(Long id, String name, List<TechSubject> techSubjects, List<Order> orders) {
    this.id = id;
    this.name = name;
    this.techSubjects = techSubjects;
    this.orders = orders;
  }

  public List<TechSubject> getTechSubjects() {
    return techSubjects;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
