package cau.cau_be.grad.service;

import cau.cau_be.company.dto.request.JobIdRequest;
import cau.cau_be.exception.ErrorMessage;
import cau.cau_be.grad.dto.request.ResearchRequest;
import cau.cau_be.grad.dto.response.GradResponse;
import cau.cau_be.grad.dto.response.ResearchResponse;
import cau.cau_be.grad.entity.Grad;
import cau.cau_be.grad.repository.GradRepository;
import cau.cau_be.grad.repository.ResearchRepository;
import cau.cau_be.job.entity.Job;
import cau.cau_be.job.service.JobService;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.springframework.stereotype.Service;

@Service
public class GradService {

  private final GradRepository gradRepository;
  private final ResearchRepository researchRepository;
  private final JobService jobService;

  public GradService(GradRepository gradRepository, ResearchRepository researchRepository,
      JobService jobService) {
    this.gradRepository = gradRepository;
    this.researchRepository = researchRepository;
    this.jobService = jobService;
  }

  public List<GradResponse> getGradList(JobIdRequest jobIdRequest) {
    Job job = jobService.getValidJob(jobIdRequest);
    return gradRepository.findAllByJobId(job.getId()).stream()
        .map(grad -> new GradResponse(grad.getId(), grad.getName())).toList();
  }

  public List<ResearchResponse> getResearchList(ResearchRequest researchRequest) {
    Job job = jobService.getValidJob(new JobIdRequest(researchRequest.jobId()));
    Grad grad = getValidGrad(researchRequest.gradId());
    return researchRepository.findAllByJobId(job.getId()).stream()
        .filter(research -> Objects.equals(
            research.getGrad().getId(), grad.getId()))
        .map(research -> new ResearchResponse(
            research.getId(), research.getName())).toList();
  }

  private Grad getValidGrad(Long gradId) {
    return gradRepository.findById(gradId).orElseThrow(() -> new NoSuchElementException(
        ErrorMessage.NOT_FOUND_GRAD.getErrorMessage()));
  }
}
