package com.bestbuy.todo.si;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bestbuy.todo.exceptions.TODOException;
import com.bestbuy.todo.model.ErrorModel;

public abstract class AbstractController {

  @Resource(name = "errorCodesMap")
  Map<String, Integer> errorCodesMap;

  /**
   * Generic exception handler for TODOException, here based on error code http status code will be
   * fetched from errorCodes map.
   * 
   * @param ex
   * @param response
   * @return
   */
  @ResponseBody
  @ExceptionHandler(TODOException.class)
  public ErrorModel handleTODOException(TODOException ex, HttpServletResponse response) {

    response.setStatus(errorCodesMap.get(ex.getErrorCode()));

    ErrorModel errorModel = new ErrorModel();
    errorModel.setError_code(ex.getErrorCode());
    errorModel.setError_message(ex.getErrorMsg());
    return errorModel;

  }
}
