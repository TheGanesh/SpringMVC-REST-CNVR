package com.bestbuy.todo.si;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.integration.Message;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bestbuy.todo.model.TodoResource;
import com.bestbuy.todo.model.TodoResponse;

@Controller
public class RESTController extends AbstractController {

  @Inject
  MessageHandler apiHandler;

  @Inject
  @Named("todoService")
  TodoService todoService;

  @ResponseBody
  @RequestMapping(value = "/todo", method = RequestMethod.POST, consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
  @ResponseStatus(HttpStatus.OK)
  public TodoResponse invokeTodo(@Valid @RequestBody TodoResource request,BindingResult bindingResult) throws Exception {

	if(bindingResult.hasErrors()){
		
		for(ObjectError error:bindingResult.getAllErrors()){

			System.out.println(error.getObjectName());
			System.out.println("error.getCode():"+error.getCode());
			System.out.println("error.getDefaultMessage():"+error.getDefaultMessage());
		}
	}
    TodoResponse response = new TodoResponse();
    response.setTodoId(request.getTodoId());
    return response;
  }

  @ResponseBody
  @RequestMapping(value = "/todos", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
  @ResponseStatus(HttpStatus.OK)
  public TodoResponse getTodos(@RequestHeader Map<String, Object> headers) throws Exception {

    Message<Object> message = MessageBuilder.withPayload(new Object()).copyHeaders(headers).build();
    TodoResponse response = (TodoResponse) apiHandler.handle(message);
    return response;

  }

}
