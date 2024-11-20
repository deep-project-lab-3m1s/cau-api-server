package cau.cau_be.tech.service;

import cau.cau_be.exception.ErrorMessage;
import cau.cau_be.tech.dto.request.TechIdRequest;
import cau.cau_be.tech.dto.response.TechDescriptionResponse;
import cau.cau_be.tech.dto.response.TechSubclassResponse;
import cau.cau_be.tech.entity.Tech;
import cau.cau_be.tech.entity.TechDescription;
import cau.cau_be.tech.repository.TechDescriptionRepository;
import cau.cau_be.tech.repository.TechRepository;
import cau.cau_be.tech.repository.TechSubclassRepository;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class TechService {

  private final TechDescriptionRepository techDescriptionRepository;
  private final TechSubclassRepository techSubclassRepository;
  private final TechRepository techRepository;

  public TechService(TechDescriptionRepository techDescriptionRepository,
      TechSubclassRepository techSubclassRepository, TechRepository techRepository) {
    this.techDescriptionRepository = techDescriptionRepository;
    this.techSubclassRepository = techSubclassRepository;
    this.techRepository = techRepository;
  }

  public TechDescriptionResponse getTechDescription(TechIdRequest techIdRequest) {
    Tech tech = getValidTech(techIdRequest.techId());
    TechDescription techDescription = getValidTechDescription(tech.getId());

    return new TechDescriptionResponse(techDescription.getDescription());
  }

  public List<TechSubclassResponse> getTechSubclassList(TechIdRequest techIdRequest) {
    Tech tech = getValidTech(techIdRequest.techId());
    return techSubclassRepository.findAllByTechId(tech.getId()).stream()
        .map(techSubclass -> new TechSubclassResponse(
            techSubclass.getId(), techSubclass.getName())).toList();
  }

  private Tech getValidTech(Long techId) {
    return techRepository.findById(techId).orElseThrow(
        () -> new NoSuchElementException(ErrorMessage.NOT_FOUND_TECH.getErrorMessage()));
  }

  private TechDescription getValidTechDescription(Long techId) {

    return techDescriptionRepository.findByTechId(techId)
        .orElseThrow(
            () -> new NoSuchElementException(
                ErrorMessage.NOT_FOUND_TECH_DESCRIPTION.getErrorMessage()));
  }
}
