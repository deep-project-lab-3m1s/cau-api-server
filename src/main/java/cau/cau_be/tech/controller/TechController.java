package cau.cau_be.tech.controller;

import cau.cau_be.tech.dto.request.TechIdRequest;
import cau.cau_be.tech.dto.response.TechDescriptionResponse;
import cau.cau_be.tech.service.TechService;
import io.swagger.v3.oas.annotations.tags.Tag;
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

  public TechController(TechService techService) {
    this.techService = techService;
  }

  @GetMapping("/description/{techId}")
  public ResponseEntity<TechDescriptionResponse> getTechDescription(
      @PathVariable(name = "techId") Long techId) {
    return ResponseEntity.ok().body(techService.getTechDescription(new TechIdRequest(techId)));
  }
}
