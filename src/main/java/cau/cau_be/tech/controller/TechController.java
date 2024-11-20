package cau.cau_be.tech.controller;

import cau.cau_be.certificate.dto.response.CertificateResponse;
import cau.cau_be.certificate.service.CertificateService;
import cau.cau_be.exception.ExceptionResponse;
import cau.cau_be.tech.dto.request.TechIdRequest;
import cau.cau_be.tech.dto.response.TechDescriptionResponse;
import cau.cau_be.tech.dto.response.TechSubclassResponse;
import cau.cau_be.tech.service.TechService;
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
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "기술", description = "기술 관련 API")
@RestController
@RequestMapping("/api/tech")
public class TechController {

  private final TechService techService;
  private final CertificateService certificateService;

  public TechController(TechService techService, CertificateService certificateService) {
    this.techService = techService;
    this.certificateService = certificateService;
  }

  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "기술 스택 상세 설명 조회 성공", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TechDescriptionResponse.class))),
      @ApiResponse(responseCode = "404", description = "요청한 리소스가 없음", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class)))
  })
  @GetMapping("/description/{techId}")
  public ResponseEntity<TechDescriptionResponse> getTechDescription(
      @PathVariable(name = "techId") Long techId) {
    return ResponseEntity.ok().body(techService.getTechDescription(new TechIdRequest(techId)));
  }

  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "기술 하위 리스트 조회 성공", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = TechSubclassResponse.class)))),
      @ApiResponse(responseCode = "404", description = "요청한 리소스가 없음", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class)))
  })
  @GetMapping("/subclass/{techId}")
  public ResponseEntity<List<TechSubclassResponse>> getTechSubclassList(
      @PathVariable(name = "techId") Long techId) {
    return ResponseEntity.ok().body(techService.getTechSubclassList(new TechIdRequest(techId)));
  }

  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "기술 관련 자격증 리스트 조회 성공", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CertificateResponse.class)))),
      @ApiResponse(responseCode = "404", description = "요청한 리소스가 없음", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class)))
  })
  @GetMapping("/certificate/{techId}")
  public ResponseEntity<List<CertificateResponse>> getCertificateList(
      @PathVariable(name = "techId") Long techId) {
    return ResponseEntity.ok()
        .body(certificateService.getCertificateList(new TechIdRequest(techId)));
  }
}
