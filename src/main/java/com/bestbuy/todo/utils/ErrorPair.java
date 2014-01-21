package com.bestbuy.todo.utils;

public class ErrorPair {

  private Integer httpStatusCode;

  private String shortMessage;

  private String longMessage;

  public Integer getHttpStatusCode() {
    return httpStatusCode;
  }

  public void setHttpStatusCode(Integer httpStatusCode) {
    this.httpStatusCode = httpStatusCode;
  }

public String getShortMessage() {
	return shortMessage;
}

public void setShortMessage(String shortMessage) {
	this.shortMessage = shortMessage;
}

public String getLongMessage() {
	return longMessage;
}

public void setLongMessage(String longMessage) {
	this.longMessage = longMessage;
}

}
