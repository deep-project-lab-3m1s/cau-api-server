package cau.cau_be.startup.entity;

import cau.cau_be.tech.entity.Tech;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class StartupTech {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private final Long id;

  @OneToOne
  @JoinColumn(name = "tech_id", nullable = false)
  private final Tech tech;

  protected StartupTech() {
    this(null, null);
  }

  public StartupTech(Long id, Tech tech) {
    this.id = id;
    this.tech = tech;
  }

  public Tech getTech() {
    return tech;
  }
}
