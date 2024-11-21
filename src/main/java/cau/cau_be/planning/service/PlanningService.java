package cau.cau_be.planning.service;

import cau.cau_be.certificate.entity.Certificate;
import cau.cau_be.planning.dto.response.PlanningCertificateResponse;
import cau.cau_be.planning.dto.response.PlanningSubjectResponse;
import cau.cau_be.planning.dto.response.PlanningTechResponse;
import cau.cau_be.planning.repository.PlanningCertificateRepository;
import cau.cau_be.planning.repository.PlanningSubjectRepository;
import cau.cau_be.planning.repository.PlanningTechRepository;
import cau.cau_be.subject.entity.Subject;
import cau.cau_be.tech.entity.Tech;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PlanningService {

  private final PlanningTechRepository planningTechRepository;
  private final PlanningSubjectRepository planningSubjectRepository;
  private final PlanningCertificateRepository planningCertificateRepository;

  public PlanningService(PlanningTechRepository planningTechRepository,
      PlanningSubjectRepository planningSubjectRepository,
      PlanningCertificateRepository planningCertificateRepository) {
    this.planningTechRepository = planningTechRepository;
    this.planningSubjectRepository = planningSubjectRepository;
    this.planningCertificateRepository = planningCertificateRepository;
  }

  public List<PlanningTechResponse> getPlanningTechList() {
    return planningTechRepository.findAll().stream().map(planningTech -> {
      Tech tech = planningTech.getTech();
      return new PlanningTechResponse(tech.getId(), tech.getName());
    }).toList();
  }

  public List<PlanningSubjectResponse> getPlanningSubjectList() {
    return planningSubjectRepository.findAll().stream().map(planningSubject -> {
      Subject subject = planningSubject.getSubject();
      return new PlanningSubjectResponse(subject.getId(), subject.getName());
    }).toList();
  }

  public List<PlanningCertificateResponse> getPlanningCertificateList() {
    return planningCertificateRepository.findAll().stream().map(planningCertificate -> {
      Certificate certificate = planningCertificate.getCertificate();
      return new PlanningCertificateResponse(certificate.getId(), certificate.getName());
    }).toList();
  }
}
