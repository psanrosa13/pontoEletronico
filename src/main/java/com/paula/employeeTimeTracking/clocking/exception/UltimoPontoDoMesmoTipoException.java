package com.paula.employeeTimeTracking.clocking.exception;

public class UltimoPontoDoMesmoTipoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1273480209912041829L;

	
	 public UltimoPontoDoMesmoTipoException(){
		 super("You can send same clocking record multiple times for the same type");
	 }
}
