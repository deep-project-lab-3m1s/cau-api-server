package cau.cau_be.subject.entity;

import cau.cau_be.common.entity.JobSubject;
import cau.cau_be.common.entity.TechSubject;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Subject {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private final Long id;

  @Column(nullable = false)
  private final String name;

  @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
  private final List<JobSubject> jobSubjects;

  @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
  private final List<TechSubject> techSubjects;

  protected Subject() {
    this(null, null, null, null);
  }

  public Subject(String name) {
    this(null, name, null, null);
  }

  public Subject(Long id, String name, List<JobSubject> jobSubjects,
      List<TechSubject> techSubjects) {
    this.id = id;
    this.name = name;
    this.jobSubjects = jobSubjects;
    this.techSubjects = techSubjects;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
