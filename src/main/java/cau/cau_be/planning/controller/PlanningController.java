package cau.cau_be.planning.controller;

import cau.cau_be.planning.dto.response.PlanningSubjectResponse;
import cau.cau_be.planning.dto.response.PlanningTechResponse;
import cau.cau_be.planning.service.PlanningService;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "기획", description = "기획 관련 API")
@RestController
@RequestMapping("/api/planning")
public class PlanningController {

  private final PlanningService planningService;

  public PlanningController(PlanningService planningService) {
    this.planningService = planningService;
  }

  @ApiResponse(responseCode = "200", description = "기획 관련 기술 스택 리스트 조회 성공", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PlanningTechResponse.class))))
  @GetMapping("/tech")
  public ResponseEntity<List<PlanningTechResponse>> getPlanningTechList() {
    return ResponseEntity.ok().body(planningService.getPlanningTechList());
  }

  @ApiResponse(responseCode = "200", description = "기획 관련 과목 리스트 조회 성공", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PlanningSubjectResponse.class))))
  @GetMapping("/subject")
  public ResponseEntity<List<PlanningSubjectResponse>> getPlanningSubjectList() {
    return ResponseEntity.ok().body(planningService.getPlanningSubjectList());
  }
}
