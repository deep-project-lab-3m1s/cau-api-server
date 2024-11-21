package cau.cau_be.startup.controller;

import cau.cau_be.startup.dto.response.StartupCertificateResponse;
import cau.cau_be.startup.dto.response.StartupSubjectResponse;
import cau.cau_be.startup.dto.response.StartupTechResponse;
import cau.cau_be.startup.service.StartupService;
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

@Tag(name = "창업", description = "창업 관련 API")
@RestController
@RequestMapping("/api/startup")
public class StartupController {

  private final StartupService startupService;

  public StartupController(StartupService startupService) {
    this.startupService = startupService;
  }

  @ApiResponse(responseCode = "200", description = "창업 관련 기술 스택 리스트 조회 성공", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = StartupTechResponse.class))))
  @GetMapping("/tech")
  public ResponseEntity<List<StartupTechResponse>> getStartupTechList() {
    return ResponseEntity.ok().body(startupService.getStartupTechList());
  }

  @ApiResponse(responseCode = "200", description = "창업 관련 과목 리스트 조회 성공", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = StartupSubjectResponse.class))))
  @GetMapping("/subject")
  public ResponseEntity<List<StartupSubjectResponse>> getStartupSubjectList() {
    return ResponseEntity.ok().body(startupService.getStartupSubjectList());
  }

  @ApiResponse(responseCode = "200", description = "창업 관련 자격증 리스트 조회 성공", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = StartupCertificateResponse.class))))
  @GetMapping("/certificate")
  public ResponseEntity<List<StartupCertificateResponse>> getStartupCertificateList() {
    return ResponseEntity.ok().body(startupService.getStartupCertificateList());
  }
}
