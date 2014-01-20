package com.bestbuy.todo.exceptions;

import java.util.List;

/**
 * Exception class used for all exception scenarios of todo activities
 * 
 * @author Ganesh
 */
public class TODOException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  private List<String> errorCodes;

  public TODOException(List<String> errorCodes) {
    this.errorCodes = errorCodes;
  }

  public List<String> getErrorCodes() {
    return errorCodes;
  }

  public void setErrorCodes(List<String> errorCodes) {
    this.errorCodes = errorCodes;
  }


}
