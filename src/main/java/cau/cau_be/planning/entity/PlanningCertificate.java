package cau.cau_be.planning.entity;

import cau.cau_be.certificate.entity.Certificate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class PlanningCertificate {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private final Long id;

  @OneToOne
  @JoinColumn(name = "certificate_id", nullable = false)
  private final Certificate certificate;

  protected PlanningCertificate() {
    this(null, null);
  }

  public PlanningCertificate(Long id, Certificate certificate) {
    this.id = id;
    this.certificate = certificate;
  }

  public Certificate getCertificate() {
    return certificate;
  }
}
