package cau.cau_be.job.service;

import cau.cau_be.job.dto.request.SelectedSubjectsRequest;
import cau.cau_be.job.dto.response.JobResponse;
import cau.cau_be.job.entity.Job;
import cau.cau_be.job.repository.JobRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class JobService {

  private final JobRepository jobRepository;

  public JobService(JobRepository jobRepository) {
    this.jobRepository = jobRepository;
  }

  public List<JobResponse> getRecommendedJobs(SelectedSubjectsRequest selectedSubjectsRequest) {
    List<Job> recommendedJobs = jobRepository.findAllBySubjectIds(
        selectedSubjectsRequest.selectedSubjects());
    return recommendedJobs.stream()
        .map(job -> new JobResponse(job.getId(), job.getName(), job.getDescription())).toList();
  }
}
