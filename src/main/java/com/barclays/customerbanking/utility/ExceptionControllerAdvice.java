package com.barclays.customerbanking.utility;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.barclays.customerbanking.constants.SystemConstants;
import com.barclays.customerbanking.exception.BarclaysException;

@RestControllerAdvice
public class ExceptionControllerAdvice {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> exceptionHandler(Exception exception) {
		ErrorInfo error = new ErrorInfo();
		error.setErrorMessage(SystemConstants.REQUEST_CANT_BE_PROCESSED);
		error.setErrorCode(HttpStatus.ACCEPTED.value());
		error.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(BarclaysException.class)
	public ResponseEntity<ErrorInfo> thBankExceptionHandler(BarclaysException exception) {
		ErrorInfo error = new ErrorInfo();
		error.setErrorMessage(exception.getMessage());
		error.setTimestamp(LocalDateTime.now());
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.NOT_FOUND);
	}

}