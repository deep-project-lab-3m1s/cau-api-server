package cau.cau_be.common.entity;

import cau.cau_be.job.entity.Job;
import cau.cau_be.subject.entity.Subject;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class JobSubject {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private final Long id;

  @ManyToOne
  @JoinColumn(name = "job_id", nullable = false)
  private final Job job;

  @ManyToOne
  @JoinColumn(name = "subject_id", nullable = false)
  private final Subject subject;

  protected JobSubject() {
    this(null, null, null);
  }

  public JobSubject(Long id, Job job, Subject subject) {
    this.id = id;
    this.job = job;
    this.subject = subject;
  }
}
