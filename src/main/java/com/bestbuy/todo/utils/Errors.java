package com.bestbuy.todo.utils;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"error"})
@XmlRootElement(name = "Errors")
public class Errors {

  @XmlElement(name = "Error")
  protected List<Errors.Error> error;

  public List<Errors.Error> getError() {
    if (error == null) {
      error = new ArrayList<Errors.Error>();
    }
    return this.error;
  }

  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(name = "", propOrder = {"httpStatusCode", "shortMessage", "longMessage", "message"})
  public static class Error {

    @XmlElement(name = "HttpStatusCode")
    protected Integer httpStatusCode;
    @XmlElement(name = "ShortMessage", required = true)
    protected String shortMessage;
    @XmlElement(name = "LongMessage", required = true)
    protected String longMessage;
    @XmlElement(name = "Message", required = true)
    protected String message;
    @XmlAttribute(name = "code")
    protected String code;

    public Integer getHttpStatusCode() {
      return httpStatusCode;
    }

    public void setHttpStatusCode(Integer httpStatusCode) {
      this.httpStatusCode = httpStatusCode;
    }

    /**
     * Gets the value of the shortMessage property.
     * 
     * @return
     *         possible object is {@link String }
     */
    public String getShortMessage() {
      return shortMessage;
    }

    /**
     * Sets the value of the shortMessage property.
     * 
     * @param value
     *          allowed object is {@link String }
     */
    public void setShortMessage(String value) {
      this.shortMessage = value;
    }

    /**
     * Gets the value of the longMessage property.
     * 
     * @return
     *         possible object is {@link String }
     */
    public String getLongMessage() {
      return longMessage;
    }

    /**
     * Sets the value of the longMessage property.
     * 
     * @param value
     *          allowed object is {@link String }
     */
    public void setLongMessage(String value) {
      this.longMessage = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *         possible object is {@link String }
     */
    public String getMessage() {
      return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *          allowed object is {@link String }
     */
    public void setMessage(String value) {
      this.message = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *         possible object is {@link String }
     */
    public String getCode() {
      return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *          allowed object is {@link String }
     */
    public void setCode(String value) {
      this.code = value;
    }

  }

}
