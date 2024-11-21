package cau.cau_be.startup.service;

import cau.cau_be.startup.dto.response.StartupTechResponse;
import cau.cau_be.startup.repository.StartupTechRepository;
import cau.cau_be.tech.entity.Tech;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StartupService {

  private final StartupTechRepository startupTechRepository;

  public StartupService(StartupTechRepository startupTechRepository) {
    this.startupTechRepository = startupTechRepository;
  }

  public List<StartupTechResponse> getStartupTechList() {
    return startupTechRepository.findAll().stream().map(startupTech -> {
      Tech tech = startupTech.getTech();
      return new StartupTechResponse(tech.getId(), tech.getName());
    }).toList();
  }


}
