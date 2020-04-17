package com.paula.pontoEletronico.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.paula.pontoEletronico.usuario.exception.UsuarioInexistenteException;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler{


	@org.springframework.web.bind.annotation.ExceptionHandler( {UsuarioInexistenteException.class} )
	protected ResponseEntity<Object> trataError(UsuarioInexistenteException exception) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(exception.getMessage());
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler( {Exception.class} )
	protected ResponseEntity<Object> tratar(Exception exception) {
			exception.printStackTrace();
			
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>OOOOOOOOOOOOOOOOOOOOOOOO");
		
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(exception.getMessage());
	}
	
	
}
