package com.example.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionService {

    @ExceptionHandler
    ResponseEntity<UserIdException> handleUserIdException(UserIdException err) {
        UserErrorResponse userErrorResponse = new UserErrorResponse();
        userErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        userErrorResponse.setMessage("You have entered id " + err.getMessage() + " invalid.");
        return new ResponseEntity(userErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    ResponseEntity<UserCPFException> handleUserCPFException(UserCPFException err){
        UserErrorResponse uer =new UserErrorResponse();
        uer.setStatus(HttpStatus.NOT_FOUND.value());
        uer.setMessage("You have entered CPF " + err.getMessage() + " invalid.");
        return new ResponseEntity(uer,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    ResponseEntity<UserNameException> handleUserNameException(UserNameException err){
        UserErrorResponse uer =new UserErrorResponse();
        uer.setStatus(HttpStatus.NOT_FOUND.value());
        uer.setMessage("You have entered username "+err.getMessage()+" invalid.");
        return new ResponseEntity(uer,HttpStatus.NOT_FOUND);
    }
}
