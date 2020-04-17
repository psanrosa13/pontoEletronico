package com.paula.pontoEletronico.ponto.exception;

public class UltimoPontoDoMesmoTipoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1273480209912041829L;

	
	 public UltimoPontoDoMesmoTipoException(){
		 super("Você não pode registrar o ponto com mesmo tipo vezes seguidas.");
	 }
}
