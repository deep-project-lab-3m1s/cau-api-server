package cau.cau_be.tech.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class TechDescription {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private final Long id;

  @Column(nullable = false, columnDefinition = "TEXT")
  private final String description;

  @OneToOne
  @JoinColumn(name = "tech_id", nullable = false)
  private final Tech tech;

  protected TechDescription() {
    this(null, null, null);
  }

  public TechDescription(Long id, String description, Tech tech) {
    this.id = id;
    this.description = description;
    this.tech = tech;
  }

  public String getDescription() {
    return description;
  }
}
