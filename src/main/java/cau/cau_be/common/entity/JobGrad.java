package cau.cau_be.common.entity;

import cau.cau_be.grad.entity.Grad;
import cau.cau_be.job.entity.Job;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class JobGrad {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private final Long id;

  @ManyToOne
  @JoinColumn(name = "job_id", nullable = false)
  private final Job job;

  @ManyToOne
  @JoinColumn(name = "grad_id", nullable = false)
  private final Grad grad;

  protected JobGrad() {
    this(null, null, null);
  }

  public JobGrad(Long id, Job job, Grad grad) {
    this.id = id;
    this.job = job;
    this.grad = grad;
  }
}
