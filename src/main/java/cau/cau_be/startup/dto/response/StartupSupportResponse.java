package cau.cau_be.startup.dto.response;

public record StartupSupportResponse(
    Long id,
    String title,
    String content,
    String supporter
) {

}
