package com.coletas.coletas.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {org.springframework.security.core.AuthenticationException.class})
    public ResponseEntity<Object> handleAuthenticationException(Exception ex, WebRequest request) {
        return new ResponseEntity<>("Erro de autenticação: " + ex.getMessage(), HttpStatus.UNAUTHORIZED); // 401
    }

    @ExceptionHandler(value = {AccessDeniedException.class})
    public ResponseEntity<Object> handleAccessDeniedException(Exception ex, WebRequest request) {
        return new ResponseEntity<>("Acesso negado: " + ex.getMessage(), HttpStatus.FORBIDDEN); // 403
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResponseEntity<Object> handleIllegalArgumentException(Exception ex, WebRequest request) {
        return new ResponseEntity<>("Requisição inválida: " + ex.getMessage(), HttpStatus.BAD_REQUEST); // 400
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleGenericException(Exception ex, WebRequest request) {
        return new ResponseEntity<>("Erro interno no servidor: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR); // 500
    }
}