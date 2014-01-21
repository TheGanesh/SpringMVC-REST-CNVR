package com.bestbuy.todo.si;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bestbuy.config.ErrorCodesConfig;
import com.bestbuy.todo.exceptions.TODOException;
import com.bestbuy.todo.exceptions.ValidationException;
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
	public Errors handleTODOException(TODOException ex,
			HttpServletResponse response) {

		Map<String, ErrorPair> errorsMap = errorCodesConfig.getErrorsMap();

		Errors errors = new Errors();
		Integer httpStatusCode = null;

		for (String errorCode : ex.getErrorCodes()) {

			ErrorPair errorPair = errorsMap.get(errorCode);

			Errors.Error error = new Errors.Error();
			error.setCode(errorCode);
			error.setMessage(errorPair.getLongMessage());
			httpStatusCode = errorPair.getHttpStatusCode();
			errors.getError().add(error);

		}
		response.setStatus(httpStatusCode);

		return errors;

	}

	@ResponseBody
	@ExceptionHandler(ValidationException.class)
	public Errors handleValidationException(ValidationException ex,
			HttpServletResponse response) {

		Map<String, ErrorPair> errorsMap = errorCodesConfig.getErrorsMap();

		Errors errors = new Errors();

		ErrorPair errorPair = errorsMap.get(ex.getErrorCode());

		Errors.Error error = new Errors.Error();
		error.setCode(ex.getErrorCode());
		error.setMessage(ex.getPropertyPath() + " "
				+ errorPair.getLongMessage());
		errors.getError().add(error);

		response.setStatus(errorPair.getHttpStatusCode());

		return errors;

	}

}
