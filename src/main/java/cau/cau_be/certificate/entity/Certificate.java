package cau.cau_be.certificate.entity;

import cau.cau_be.tech.entity.Tech;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Certificate {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private final Long id;

  @Column(nullable = false)
  private final String name;

  @ManyToOne
  @JoinColumn(name = "tech_id", nullable = false)
  private final Tech tech;

  protected Certificate() {
    this(null, null, null);
  }

  public Certificate(Long id, String name, Tech tech) {
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
