package cau.cau_be.exception;

public enum ErrorMessage {
  NOT_FOUND_JOB("해당 ID의 직종이 없습니다."),
  NOT_FOUND_ROADMAP("요청한 직종 ID에 해당하는 로드맵이 없습니다."),
  NOT_FOUND_TECH("요청한 ID의 기술 스택이 존재하지 않습니다."),
  NOT_FOUND_TECH_DESCRIPTION("요청한 기술 스택의 상세 설명이 존재하지 않습니다.");

  private final String errorMessage;

  ErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public String getErrorMessage() {
    return errorMessage;
  }
}
