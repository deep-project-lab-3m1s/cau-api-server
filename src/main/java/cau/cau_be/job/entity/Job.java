package cau.cau_be.job.entity;

import cau.cau_be.common.entity.JobSubject;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Job {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private final Long id;

  @Column(nullable = false)
  private final String name;

  @Column(nullable = false, columnDefinition = "TEXT")
  private final String description;

  @Column(nullable = false)
  private final Long salary;

  @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, orphanRemoval = true)
  private final List<JobSubject> jobSubjects;

  protected Job() {
    this(null, null, null, null, null);
  }

  public Job(String name, String description, Long salary) {
    this(null, name, description, salary, null);
  }

  public Job(Long id, String name, String description, Long salary, List<JobSubject> jobSubjects) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.salary = salary;
    this.jobSubjects = jobSubjects;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }
}
