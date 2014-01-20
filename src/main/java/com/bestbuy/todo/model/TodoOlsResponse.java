package com.bestbuy.todo.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"olsData"})
@XmlRootElement(name = "todoResponse")
public class TodoOlsResponse extends TodoResponse {

  @XmlElement(required = true)
  protected String olsData;

  /**
   * Gets the value of the olsData property.
   * 
   * @return
   *         possible object is {@link String }
   */
  public String getOlsData() {
    return olsData;
  }

  /**
   * Sets the value of the olsData property.
   * 
   * @param value
   *          allowed object is {@link String }
   */
  public void setOlsData(String value) {
    this.olsData = value;
  }

}
