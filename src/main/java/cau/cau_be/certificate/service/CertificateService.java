package cau.cau_be.certificate.service;

import cau.cau_be.certificate.dto.response.CertificateResponse;
import cau.cau_be.certificate.repository.CertificateRepository;
import cau.cau_be.tech.dto.request.TechIdRequest;
import cau.cau_be.tech.entity.Tech;
import cau.cau_be.tech.service.TechService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CertificateService {

  private final CertificateRepository certificateRepository;
  private final TechService techService;

  public CertificateService(CertificateRepository certificateRepository,
      TechService techService) {
    this.certificateRepository = certificateRepository;
    this.techService = techService;
  }

  public List<CertificateResponse> getCertificateList(TechIdRequest techIdRequest) {
    Tech tech = techService.getValidTech(techIdRequest.techId());

    return certificateRepository.findAllByTechId(tech.getId()).stream()
        .map(certificate -> new CertificateResponse(
            certificate.getId(), certificate.getName())).toList();
  }
}
