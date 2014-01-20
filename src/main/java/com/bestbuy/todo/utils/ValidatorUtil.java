package com.bestbuy.todo.utils;

import java.util.Set;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.stereotype.Component;

import com.bestbuy.todo.exceptions.ValidationException;
import com.bestbuy.todo.model.TodoResource;

/**
 * This is a generic validator class which is used to validate all input fields for todo tasks.
 * 
 * @author Ganesh
 */
@Component("validatorUtil")
public class ValidatorUtil {

  @Inject
  private Validator validator;

  /**
   * Validates TodoResource object before creating new todo task, this validation is done using Bean validation
   * framework JSR 303
   * 
   * @param type
   */
  public void validate(TodoResource type) {

    Set<ConstraintViolation<TodoResource>> constraintViolations = validator.validate(type);

    if (!constraintViolations.isEmpty()) {

      for (ConstraintViolation<TodoResource> violation : constraintViolations) {

        throw new ValidationException(violation.getPropertyPath().toString(), violation.getMessage());

      }
    }

  }

}
