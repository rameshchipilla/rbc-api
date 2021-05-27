package git.rbc.api.error;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class APIExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public APIError handleValidationError(MethodArgumentNotValidException ex) {
		BindingResult bindingResult = ex.getBindingResult();
		FieldError fieldError = bindingResult.getFieldError();
		String defaultMessage = fieldError.getDefaultMessage();
		return new APIError("VALIDATION_FAILED", defaultMessage);
	}
}