package com.bestbuy.todo.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"mdotData"})
@XmlRootElement(name = "todoResponse")
public class TodoMdotResponse extends TodoResponse {

  @XmlElement(required = true)
  protected String mdotData;

  /**
   * Gets the value of the mdotData property.
   * 
   * @return
   *         possible object is {@link String }
   */
  public String getMdotData() {
    return mdotData;
  }

  /**
   * Sets the value of the mdotData property.
   * 
   * @param value
   *          allowed object is {@link String }
   */
  public void setMdotData(String value) {
    this.mdotData = value;
  }

}
