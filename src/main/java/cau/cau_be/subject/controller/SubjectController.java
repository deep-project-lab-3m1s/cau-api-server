package cau.cau_be.subject.controller;

import cau.cau_be.subject.dto.response.SubjectResponse;
import cau.cau_be.subject.service.SubjectService;
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

@Tag(name = "과목", description = "과목 관련 API")
@RestController
@RequestMapping("/api")
public class SubjectController {

  private final SubjectService subjectService;

  public SubjectController(SubjectService subjectService) {
    this.subjectService = subjectService;
  }

  @ApiResponse(responseCode = "200", description = "전체 과목 조회 완료", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = SubjectResponse.class))))
  @GetMapping("/subject")
  public ResponseEntity<List<SubjectResponse>> getSubjectList() {
    return ResponseEntity.ok().body(subjectService.getSubjectList());
  }
}
