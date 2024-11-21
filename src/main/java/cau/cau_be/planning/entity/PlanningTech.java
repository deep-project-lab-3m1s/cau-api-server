package cau.cau_be.planning.entity;

import cau.cau_be.tech.entity.Tech;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class PlanningTech {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private final Long id;

  @OneToOne
  @JoinColumn(name = "tech_id", nullable = false)
  private final Tech tech;

  protected PlanningTech() {
    this(null, null);
  }

  public PlanningTech(Long id, Tech tech) {
    this.id = id;
    this.tech = tech;
  }

  public Tech getTech() {
    return tech;
  }
}
