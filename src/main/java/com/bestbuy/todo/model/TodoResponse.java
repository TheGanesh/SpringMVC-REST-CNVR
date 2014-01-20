package com.bestbuy.todo.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"todoId"})
@XmlRootElement(name = "todoResponse")
public class TodoResponse  {

  @XmlElement(name = "todo_id", required = true)
  protected String todoId;

  /**
   * Gets the value of the todoId property.
   * 
   * @return
   *         possible object is {@link String }
   */
  public String getTodoId() {
    return todoId;
  }

  /**
   * Sets the value of the todoId property.
   * 
   * @param value
   *          allowed object is {@link String }
   */
  public void setTodoId(String value) {
    this.todoId = value;
  }

}
