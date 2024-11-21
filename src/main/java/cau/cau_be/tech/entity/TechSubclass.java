package cau.cau_be.tech.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class TechSubclass {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private final Long id;

  @Column(nullable = false)
  private final String name;

  @ManyToOne
  @JoinColumn(name = "tech_id", nullable = false)
  private final Tech tech;

  protected TechSubclass() {
    this(null, null, null);
  }

  public TechSubclass(Long id, String name, Tech tech) {
    this.id = id;
    this.name = name;
    this.tech = tech;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
