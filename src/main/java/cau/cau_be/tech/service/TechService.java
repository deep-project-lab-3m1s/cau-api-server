package cau.cau_be.tech.service;

import cau.cau_be.exception.ErrorMessage;
import cau.cau_be.tech.dto.request.TechIdRequest;
import cau.cau_be.tech.dto.response.TechDescriptionResponse;
import cau.cau_be.tech.entity.TechDescription;
import cau.cau_be.tech.repository.TechDescriptionRepository;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class TechService {

  private final TechDescriptionRepository techDescriptionRepository;

  public TechService(TechDescriptionRepository techDescriptionRepository) {
    this.techDescriptionRepository = techDescriptionRepository;
  }

  public TechDescriptionResponse getTechDescription(TechIdRequest techIdRequest) {
    TechDescription techDescription = getValidTechDescription(techIdRequest);

    return new TechDescriptionResponse(techDescription.getDescription());
  }

  private TechDescription getValidTechDescription(TechIdRequest techIdRequest) {

    return techDescriptionRepository.findByTechId(techIdRequest.techId())
        .orElseThrow(
            () -> new NoSuchElementException(ErrorMessage.NOT_FOUND_TECH.getErrorMessage()));
  }
}
