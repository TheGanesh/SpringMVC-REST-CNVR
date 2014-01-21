package com.bestbuy.todo.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"todoId", "todoTitle", "finished", "createdAt"})
@XmlRootElement(name = "todoResource")
public class TodoResource {

  @XmlElement(name = "todo_id", required = true)
  protected String todoId;

  @XmlElement(name = "todo_title", required = true)
  @NotNull(message = "REQ00001-todoTitle")
  @Size(min = 0, max = 20, message = "REQ00002-todoTitle-0-20")
  protected String todoTitle;

  @XmlElement(required = true)
  protected String finished;

  @XmlElement(name = "created_at", required = true)
  protected String createdAt;

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

  /**
   * Gets the value of the todoTitle property.
   * 
   * @return
   *         possible object is {@link String }
   */
  public String getTodoTitle() {
    return todoTitle;
  }

  /**
   * Sets the value of the todoTitle property.
   * 
   * @param value
   *          allowed object is {@link String }
   */
  public void setTodoTitle(String value) {
    this.todoTitle = value;
  }

  /**
   * Gets the value of the finished property.
   * 
   * @return
   *         possible object is {@link String }
   */
  public String getFinished() {
    return finished;
  }

  /**
   * Sets the value of the finished property.
   * 
   * @param value
   *          allowed object is {@link String }
   */
  public void setFinished(String value) {
    this.finished = value;
  }

  /**
   * Gets the value of the createdAt property.
   * 
   * @return
   *         possible object is {@link String }
   */
  public String getCreatedAt() {
    return createdAt;
  }

  /**
   * Sets the value of the createdAt property.
   * 
   * @param value
   *          allowed object is {@link String }
   */
  public void setCreatedAt(String value) {
    this.createdAt = value;
  }

  @Override
  public String toString() {
    return "TodoResource [todo_id=" + todoId + ", todo_title=" + todoTitle + ", finished=" + finished + ", created_at=" + createdAt + "]";
  }

}
