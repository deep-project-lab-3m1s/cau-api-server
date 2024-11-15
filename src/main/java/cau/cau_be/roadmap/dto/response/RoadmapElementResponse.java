package cau.cau_be.roadmap.dto.response;

import java.util.List;

public record RoadmapElementResponse(
    Long techId,
    String techName,
    int order,
    List<String> relatedSubjects
) {

}
