package cau.cau_be.company.service;

import cau.cau_be.company.dto.request.JobIdRequest;
import cau.cau_be.company.dto.response.CompanyResponse;
import cau.cau_be.company.entity.Company;
import cau.cau_be.company.repository.CompanyRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

  private final CompanyRepository companyRepository;

  public CompanyService(CompanyRepository companyRepository) {
    this.companyRepository = companyRepository;
  }

  public List<CompanyResponse> getCompaniesRelatedJob(JobIdRequest jobIdRequest) {
    List<Company> companiesRelatedJob = companyRepository.findAllByJobId(jobIdRequest.id());
    return companiesRelatedJob.stream().map(company -> new CompanyResponse(company.getName()))
        .toList();
  }
}
