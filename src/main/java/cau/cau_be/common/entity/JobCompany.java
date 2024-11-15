package cau.cau_be.common.entity;

import cau.cau_be.company.entity.Company;
import cau.cau_be.job.entity.Job;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class JobCompany {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private final Long id;

  @ManyToOne
  @JoinColumn(name = "job_id", nullable = false)
  private final Job job;

  @ManyToOne
  @JoinColumn(name = "company_id", nullable = false)
  private final Company company;

  protected JobCompany() {
    this(null, null, null);
  }

  public JobCompany(Long id, Job job, Company company) {
    this.id = id;
    this.job = job;
    this.company = company;
  }
}
