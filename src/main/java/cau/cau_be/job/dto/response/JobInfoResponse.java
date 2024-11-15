package cau.cau_be.job.dto.response;

import java.util.List;

public record JobInfoResponse(
    Long salary,
    List<String> majorCompanies
) {

}
