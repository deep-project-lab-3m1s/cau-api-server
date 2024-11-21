package cau.cau_be.planning.service;

import cau.cau_be.planning.dto.response.PlanningTechResponse;
import cau.cau_be.planning.repository.PlanningTechRepository;
import cau.cau_be.tech.entity.Tech;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PlanningService {

  private final PlanningTechRepository planningTechRepository;

  public PlanningService(PlanningTechRepository planningTechRepository) {
    this.planningTechRepository = planningTechRepository;
  }

  public List<PlanningTechResponse> getPlanningTechList() {
    return planningTechRepository.findAll().stream().map(planningTech -> {
      Tech tech = planningTech.getTech();
      return new PlanningTechResponse(tech.getId(), tech.getName());
    }).toList();
  }
}
