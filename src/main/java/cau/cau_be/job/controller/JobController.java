package cau.cau_be.job.controller;

import cau.cau_be.company.dto.request.JobIdRequest;
import cau.cau_be.exception.ExceptionResponse;
import cau.cau_be.job.dto.request.SelectedSubjectsRequest;
import cau.cau_be.job.dto.response.JobInfoResponse;
import cau.cau_be.job.dto.response.JobResponse;
import cau.cau_be.job.service.JobService;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  @ApiResponse(responseCode = "200", description = "직종 추천 리스트 조회 성공", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = JobResponse.class))))
  @PostMapping
  public ResponseEntity<List<JobResponse>> getRecommendedJobs(
      @RequestBody SelectedSubjectsRequest selectedSubjectsRequest) {
    return ResponseEntity.ok().body(jobService.getRecommendedJobs(selectedSubjectsRequest));
  }

  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "직종 평균 연봉 및 대표 기업 리스트 조회 성공", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = JobInfoResponse.class)))),
      @ApiResponse(responseCode = "404", description = "해당 ID의 직종이 없음", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ExceptionResponse.class))))
  })
  @GetMapping("/{jobId}")
  public ResponseEntity<JobInfoResponse> getJobInfo(
      @PathVariable(name = "jobId") Long jobId) {
    return ResponseEntity.ok().body(jobService.getJobInfo(new JobIdRequest(jobId)));
  }
}
