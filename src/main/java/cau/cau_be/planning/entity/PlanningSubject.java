package cau.cau_be.planning.entity;

import cau.cau_be.subject.entity.Subject;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class PlanningSubject {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private final Long id;

  @OneToOne
  @JoinColumn(name = "subject_id", nullable = false)
  private final Subject subject;

  protected PlanningSubject() {
    this(null, null);
  }

  public PlanningSubject(Long id, Subject subject) {
    this.id = id;
    this.subject = subject;
  }

  public Subject getSubject() {
    return subject;
  }
}
