package com31.websiteecommerce.websiteecommerce.member.controller;

import com31.websiteecommerce.websiteecommerce.member.model.ApiKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiKeyErrorController {

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value=ApiKeyException.class)
    public String apiKey(ApiKeyException exception){
        return "You are not authorized";
    }

}
