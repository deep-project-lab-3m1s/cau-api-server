package cau.cau_be.planning.service;

import cau.cau_be.planning.dto.response.PlanningSubjectResponse;
import cau.cau_be.planning.dto.response.PlanningTechResponse;
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

  public PlanningService(PlanningTechRepository planningTechRepository,
      PlanningSubjectRepository planningSubjectRepository) {
    this.planningTechRepository = planningTechRepository;
    this.planningSubjectRepository = planningSubjectRepository;
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
}
