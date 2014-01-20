package com.bestbuy.todo.exceptions;


public class ValidationException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  private String propertyPath;

  private String errorCode;

  public ValidationException(String propertyPath, String errorCode) {
    this.errorCode = errorCode;
    this.propertyPath = propertyPath;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public String getPropertyPath() {
    return propertyPath;
  }

  public void setPropertyPath(String propertyPath) {
    this.propertyPath = propertyPath;
  }

}
