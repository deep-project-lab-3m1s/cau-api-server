package cau.cau_be.common.entity;

import cau.cau_be.grad.entity.Research;
import cau.cau_be.job.entity.Job;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class JobResearch {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private final Long id;

  @ManyToOne
  @JoinColumn(name = "job_id", nullable = false)
  private final Job job;

  @ManyToOne
  @JoinColumn(name = "research_id", nullable = false)
  private final Research research;

  protected JobResearch() {
    this(null, null, null);
  }

  public JobResearch(Long id, Job job, Research research) {
    this.id = id;
    this.job = job;
    this.research = research;
  }
}
