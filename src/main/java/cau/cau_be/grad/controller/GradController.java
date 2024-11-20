package cau.cau_be.grad.controller;

import cau.cau_be.company.dto.request.JobIdRequest;
import cau.cau_be.exception.ExceptionResponse;
import cau.cau_be.grad.dto.request.ResearchRequest;
import cau.cau_be.grad.dto.response.GradResponse;
import cau.cau_be.grad.dto.response.ResearchResponse;
import cau.cau_be.grad.service.GradService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "대학원&연구", description = "대학원&연구 관련 API")
@RestController
@RequestMapping("/api/grad")
public class GradController {

  private final GradService gradService;

  public GradController(GradService gradService) {
    this.gradService = gradService;
  }

  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "직종 관련 대학원 리스트 조회 성공", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = GradResponse.class)))),
      @ApiResponse(responseCode = "404", description = "해당 ID의 직종이 없음", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class)))
  })
  @GetMapping("/{jobId}")
  public ResponseEntity<List<GradResponse>> getGradList(@PathVariable(name = "jobId") Long jobId) {
    return ResponseEntity.ok().body(gradService.getGradList(new JobIdRequest(jobId)));
  }

  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "직종과 대학원과 관련된 연구 리스트 조회 성공", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ResearchResponse.class)))),
      @ApiResponse(responseCode = "404", description = "요청한 리소스가 없음", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class)))
  })
  @GetMapping("/research")
  public ResponseEntity<List<ResearchResponse>> getResearchList(@RequestParam("jobId") Long jobId,
      @RequestParam("gradId") Long gradId) {
    return ResponseEntity.ok()
        .body(gradService.getResearchList(new ResearchRequest(jobId, gradId)));
  }
}
