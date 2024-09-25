package com.tcg.employee.custome_exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiExceptionPayload> handleResourceNotFoundException(ResourceNotFoundException e) {
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		ApiExceptionPayload apiExceptionPayload = new ApiExceptionPayload(
				e.getMessage(),
				badRequest,
				badRequest.value(),
				getCurrentLocalDateTime());
		return new ResponseEntity<>(apiExceptionPayload, badRequest);
	}
//	@ExceptionHandler(UserNotFoundException.class)
//    public ResponseEntity<ApiExceptionPayload> handleUserNotFoundException(UserNotFoundException ex) {
//		HttpStatus notFound = HttpStatus.NOT_FOUND;
//		ApiExceptionPayload error = new ApiExceptionPayload(
//				ex.getMessage(),
//				notFound,
//				notFound.value(),
//				getCurrentLocalDateTime());
//        return new ResponseEntity<>(error, notFound);
//    }
//
//    @ExceptionHandler(PasswordMismatchException.class)
//    public ResponseEntity<ApiExceptionPayload> handlePasswordMismatchException(PasswordMismatchException ex) {
//    	HttpStatus unAuthorized = HttpStatus.UNAUTHORIZED;
//    	ApiExceptionPayload error = new ApiExceptionPayload(
//    			ex.getMessage(),
//    			unAuthorized,
//    			unAuthorized.value(),
//    			getCurrentLocalDateTime());
//        return new ResponseEntity<>(error, unAuthorized);
//    }
//    
//    
//    
//    @ExceptionHandler(UserRoleNotFound.class)
//    public ResponseEntity<ApiExceptionPayload> handleUserRoleNotFoundException(UserRoleNotFound ex) {
//    	HttpStatus notFound = HttpStatus.NOT_FOUND;
//		ApiExceptionPayload error = new ApiExceptionPayload(
//				ex.getMessage(),
//				notFound,
//				notFound.value(),
//				getCurrentLocalDateTime());
//        return new ResponseEntity<>(error, notFound);
//    }
//    
//    @ExceptionHandler(AccountValidationException.class)
//    public ResponseEntity<ApiExceptionPayload> handleUserRoleNotFoundException(AccountValidationException ex) {
//    	HttpStatus notFound = HttpStatus.BAD_REQUEST;
//		ApiExceptionPayload error = new ApiExceptionPayload(
//				ex.getMessage(),
//				notFound,
//				notFound.value(),
//				getCurrentLocalDateTime());
//        return new ResponseEntity<>(error, notFound);
//    }
    
    
    
    
    
    private LocalDateTime getCurrentLocalDateTime() {
    	return LocalDateTime.now();
    }
	
	
}
