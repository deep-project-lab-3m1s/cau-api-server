package cau.cau_be.job.dto.request;

import java.util.List;

public record SelectedSubjectsRequest(
    List<Long> selectedSubjects
) {

}
