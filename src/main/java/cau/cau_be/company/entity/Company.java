package cau.cau_be.company.entity;

import cau.cau_be.common.entity.JobCompany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Company {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private final Long id;

  @Column(nullable = false)
  private final String name;

  @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
  private final List<JobCompany> jobCompanies;

  protected Company() {
    this(null, null, null);
  }

  public Company(Long id, String name, List<JobCompany> jobCompanies) {
    this.id = id;
    this.name = name;
    this.jobCompanies = jobCompanies;
  }

  public String getName() {
    return name;
  }
}
