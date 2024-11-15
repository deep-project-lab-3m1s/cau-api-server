package cau.cau_be.exception;

public enum ErrorMessage {
  NOT_FOUND_JOB("해당 ID의 직종이 없습니다.");

  private final String errorMessage;

  ErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public String getErrorMessage() {
    return errorMessage;
  }
}
