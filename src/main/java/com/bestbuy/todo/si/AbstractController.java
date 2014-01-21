package com.bestbuy.todo.si;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bestbuy.todo.exceptions.TODOException;
import com.bestbuy.todo.utils.ErrorPair;
import com.bestbuy.todo.utils.Errors;

public abstract class AbstractController {

  @Inject
  @Named("errorCodesConfig")
  ErrorCodesConfig errorCodesConfig;

  /**
   * Generic exception handler for TODOException, here based on error code
   * http status code will be fetched from errorCodes map.
   * 
   * @param ex
   * @param response
   * @return
   */
  @ResponseBody
  @ExceptionHandler(TODOException.class)
  public Errors handleTODOException(TODOException ex, HttpServletResponse response) {

    Errors errors = new Errors();
    Integer httpStatusCode = null;

    for (String errorCode : ex.getErrorCodes()) {

      String[] errorDetails = errorCode.split("-");

      String errorId = errorDetails[0];

      Object[] params = new Object[0];

      if (errorDetails.length > 1) {

        params = new Object[errorDetails.length - 1];

        for (int i = 0; i < errorDetails.length - 1; i++) {
          params[i] = errorDetails[i + 1];
          System.out.println("params[i]:" + params[i]);
        }

      }

      
      System.out.println(params);
      ErrorPair errorPair = errorCodesConfig.getErrorsMap().get(errorId);

      Errors.Error error = new Errors.Error();
      error.setCode(errorId);

      MessageFormat messageFormat = new MessageFormat(errorPair.getMessage());
      System.out.println(errorPair.getMessage());
      String finalMessage = messageFormat.format(params);
      System.out.println(finalMessage);
      error.setMessage(finalMessage);
      httpStatusCode = errorPair.getHttpStatusCode();
      errors.getError().add(error);

    }
    response.setStatus(httpStatusCode);

    return errors;

  }

  protected void handleErrors(BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
      List<String> errorCodes = new ArrayList<String>();
      for (ObjectError error : bindingResult.getAllErrors()) {
        errorCodes.add(error.getDefaultMessage());
      }
      throw new TODOException(errorCodes);
    }
  }

}
