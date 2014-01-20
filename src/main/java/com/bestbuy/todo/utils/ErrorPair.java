package com.bestbuy.todo.utils;

public class ErrorPair {

  private Integer httpStatusCode;

  private String shortError;

  private String longError;

  public Integer getHttpStatusCode() {
    return httpStatusCode;
  }

  public void setHttpStatusCode(Integer httpStatusCode) {
    this.httpStatusCode = httpStatusCode;
  }

  public String getShortError() {
    return shortError;
  }

  public void setShortError(String shortError) {
    this.shortError = shortError;
  }

  public String getLongError() {
    return longError;
  }

  public void setLongError(String longError) {
    this.longError = longError;
  }

}
