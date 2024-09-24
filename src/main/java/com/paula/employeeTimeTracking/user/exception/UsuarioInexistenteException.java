package com.paula.employeeTimeTracking.user.exception;

public class UsuarioInexistenteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3052610587484034162L;

	public UsuarioInexistenteException() {
        super("We didn't find any such user in our database");
    }
}
