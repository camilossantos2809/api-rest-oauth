package br.pucpr.oauth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DisciplinaNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(DisciplinaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String disciplinaNotFoundHandler(DisciplinaNotFoundException ex){
        return ex.getMessage();
    }
}
