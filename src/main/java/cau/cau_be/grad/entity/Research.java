package cau.cau_be.grad.entity;

import cau.cau_be.common.entity.JobResearch;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Research {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private final Long id;

  @Column(nullable = false)
  private final String name;

  @ManyToOne
  @JoinColumn(name = "grad_id", nullable = false)
  private final Grad grad;

  @OneToMany(mappedBy = "research", cascade = CascadeType.ALL, orphanRemoval = true)
  private final List<JobResearch> jobResearches;

  public Research() {
    this(null, null, null, null);
  }

  public Research(Long id, String name, Grad grad, List<JobResearch> jobResearches) {
    this.id = id;
    this.name = name;
    this.grad = grad;
    this.jobResearches = jobResearches;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Grad getGrad() {
    return grad;
  }
}
