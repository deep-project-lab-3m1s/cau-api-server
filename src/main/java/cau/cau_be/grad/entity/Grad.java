package cau.cau_be.grad.entity;

import cau.cau_be.common.entity.JobGrad;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Grad {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private final Long id;

  @Column(nullable = false)
  private final String name;

  @OneToMany(mappedBy = "grad", cascade = CascadeType.ALL, orphanRemoval = true)
  private final List<JobGrad> jobGrads;

  protected Grad() {
    this(null, null, null);
  }

  public Grad(Long id, String name, List<JobGrad> jobGrads) {
    this.id = id;
    this.name = name;
    this.jobGrads = jobGrads;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
