package cau.cau_be.job.controller;

import cau.cau_be.job.dto.request.SelectedSubjectsRequest;
import cau.cau_be.job.dto.response.JobResponse;
import cau.cau_be.job.service.JobService;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "직종", description = "직종 관련 API")
@RestController
@RequestMapping("/api/job")
public class JobController {

  private final JobService jobService;

  public JobController(JobService jobService) {
    this.jobService = jobService;
  }

  @ApiResponse(responseCode = "200", description = "직종 추천 리스트 조회 완료", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = JobResponse.class))))
  @PostMapping
  public ResponseEntity<List<JobResponse>> getRecommendedJobs(
      @RequestBody SelectedSubjectsRequest selectedSubjectsRequest) {
    return ResponseEntity.ok().body(jobService.getRecommendedJobs(selectedSubjectsRequest));
  }
}
