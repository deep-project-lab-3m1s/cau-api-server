package cau.cau_be.startup.service;

import cau.cau_be.startup.dto.response.StartupSubjectResponse;
import cau.cau_be.startup.dto.response.StartupTechResponse;
import cau.cau_be.startup.repository.StartupSubjectRepository;
import cau.cau_be.startup.repository.StartupTechRepository;
import cau.cau_be.subject.entity.Subject;
import cau.cau_be.tech.entity.Tech;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StartupService {

  private final StartupTechRepository startupTechRepository;
  private final StartupSubjectRepository startupSubjectRepository;

  public StartupService(StartupTechRepository startupTechRepository,
      StartupSubjectRepository startupSubjectRepository) {
    this.startupTechRepository = startupTechRepository;
    this.startupSubjectRepository = startupSubjectRepository;
  }

  public List<StartupTechResponse> getStartupTechList() {
    return startupTechRepository.findAll().stream().map(startupTech -> {
      Tech tech = startupTech.getTech();
      return new StartupTechResponse(tech.getId(), tech.getName());
    }).toList();
  }

  public List<StartupSubjectResponse> getStartupSubjectList() {
    return startupSubjectRepository.findAll().stream().map(startupSubject -> {
      Subject subject = startupSubject.getSubject();
      return new StartupSubjectResponse(subject.getId(), subject.getName());
    }).toList();
  }


}
