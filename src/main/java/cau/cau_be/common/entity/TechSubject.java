package cau.cau_be.common.entity;

import cau.cau_be.subject.entity.Subject;
import cau.cau_be.tech.entity.Tech;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class TechSubject {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private final Long id;

  @ManyToOne
  @JoinColumn(name = "tech_id", nullable = false)
  private final Tech tech;

  @ManyToOne
  @JoinColumn(name = "subject_id", nullable = false)
  private final Subject subject;

  protected TechSubject() {
    this(null, null, null);
  }

  public TechSubject(Long id, Tech tech, Subject subject) {
    this.id = id;
    this.tech = tech;
    this.subject = subject;
  }

  public Subject getSubject() {
    return subject;
  }
}
