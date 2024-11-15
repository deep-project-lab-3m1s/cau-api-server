package cau.cau_be.roadmap.controller;

import cau.cau_be.company.dto.request.JobIdRequest;
import cau.cau_be.roadmap.dto.response.RoadmapElementResponse;
import cau.cau_be.roadmap.service.RoadmapService;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "로드맵", description = "로드맵 관련 API")
@RestController
@RequestMapping("/api/roadmap")
public class RoadmapController {

  private final RoadmapService roadmapService;

  public RoadmapController(RoadmapService roadmapService) {
    this.roadmapService = roadmapService;
  }

  @ApiResponse(responseCode = "200", description = "로드맵 조회 완료", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = RoadmapElementResponse.class))))
  @GetMapping("/{jobId}")
  public ResponseEntity<List<RoadmapElementResponse>> getRoadmap(
      @PathVariable(name = "jobId") Long jobId) {
    return ResponseEntity.ok().body(roadmapService.getJobRoadmap(new JobIdRequest(jobId)));
  }
}
