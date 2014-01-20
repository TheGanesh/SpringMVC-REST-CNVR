package com.bestbuy.todo.si;

import org.springframework.integration.Message;
import org.springframework.integration.MessageHandlingException;
import org.springframework.stereotype.Component;

import com.bestbuy.todo.model.TodoMdotResponse;
import com.bestbuy.todo.model.TodoOlsResponse;
import com.bestbuy.todo.model.TodoResponse;

@Component("todoService")
public class TodoService {

  public TodoResponse handleMdot(Message<Object> message) throws MessageHandlingException {

    TodoMdotResponse response = new TodoMdotResponse();
    response.setTodoId("1");
    response.setMdotData("mobileApp");

    return response;

  }

  public TodoResponse handleOls(Message<Object> message) throws MessageHandlingException {

    TodoOlsResponse response = new TodoOlsResponse();
    response.setTodoId("2");
    response.setOlsData("olsApp");

    return response;

  }

}
