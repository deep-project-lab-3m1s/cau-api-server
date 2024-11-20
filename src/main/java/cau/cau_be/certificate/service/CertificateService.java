package cau.cau_be.certificate.service;

import cau.cau_be.certificate.dto.response.CertificateResponse;
import cau.cau_be.certificate.repository.CertificateRepository;
import cau.cau_be.exception.ErrorMessage;
import cau.cau_be.tech.dto.request.TechIdRequest;
import cau.cau_be.tech.entity.Tech;
import cau.cau_be.tech.repository.TechRepository;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class CertificateService {

  private final CertificateRepository certificateRepository;
  private final TechRepository techRepository;

  public CertificateService(CertificateRepository certificateRepository,
      TechRepository techRepository) {
    this.certificateRepository = certificateRepository;
    this.techRepository = techRepository;
  }

  public List<CertificateResponse> getCertificateList(TechIdRequest techIdRequest) {
    Tech tech = getValidTech(techIdRequest.techId());

    return certificateRepository.findAllByTechId(tech.getId()).stream()
        .map(certificate -> new CertificateResponse(
            certificate.getId(), certificate.getName())).toList();
  }

  private Tech getValidTech(Long techId) {
    return techRepository.findById(techId).orElseThrow(
        () -> new NoSuchElementException(ErrorMessage.NOT_FOUND_TECH.getErrorMessage()));
  }
}
