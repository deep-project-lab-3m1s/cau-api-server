package cau.cau_be.job.service;

import cau.cau_be.company.dto.request.JobIdRequest;
import cau.cau_be.company.dto.response.CompanyResponse;
import cau.cau_be.company.service.CompanyService;
import cau.cau_be.exception.ErrorMessage;
import cau.cau_be.job.dto.request.SelectedSubjectsRequest;
import cau.cau_be.job.dto.response.JobInfoResponse;
import cau.cau_be.job.dto.response.JobResponse;
import cau.cau_be.job.entity.Job;
import cau.cau_be.job.repository.JobRepository;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class JobService {

  private final JobRepository jobRepository;
  private final CompanyService companyService;

  public JobService(JobRepository jobRepository, CompanyService companyService) {
    this.jobRepository = jobRepository;
    this.companyService = companyService;
  }

  public List<JobResponse> getRecommendedJobs(SelectedSubjectsRequest selectedSubjectsRequest) {
    List<Job> recommendedJobs = jobRepository.findAllBySubjectIds(
        selectedSubjectsRequest.selectedSubjects());
    return recommendedJobs.stream()
        .map(job -> new JobResponse(job.getId(), job.getName(), job.getDescription())).toList();
  }

  public JobInfoResponse getJobInfo(JobIdRequest jobIdRequest) {
    Job job = getValidJob(jobIdRequest);
    List<CompanyResponse> companyResponses = companyService.getCompaniesRelatedJob(jobIdRequest);
    Long salary = job.getSalary();

    return new JobInfoResponse(salary,
        companyResponses.stream().map(CompanyResponse::name).toList());
  }

  public Job getValidJob(JobIdRequest jobIdRequest) {
    return jobRepository.findById(jobIdRequest.id()).orElseThrow(() -> new NoSuchElementException(
        ErrorMessage.NOT_FOUND_JOB.getErrorMessage()));
  }
}
