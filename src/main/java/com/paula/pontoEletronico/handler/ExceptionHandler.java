package com.paula.pontoEletronico.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;


import com.paula.pontoEletronico.usuario.exception.UsuarioInexistenteException;

@ControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler( {UsuarioInexistenteException.class} )
	protected ResponseEntity<Object> handleUser(UsuarioInexistenteException exception) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(exception.getMessage());
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler( {Exception.class} )
	protected ResponseEntity<Object> handle(Exception exception) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(exception.getMessage());
	}
	
	
}
