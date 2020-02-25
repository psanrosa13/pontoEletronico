package com.paula.pontoEletronico.usuario.exception;

public class UsuarioInexistenteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3052610587484034162L;

	public UsuarioInexistenteException() {
        super("Usuário não encontrado em nossa base de Dados com o id fornecedio");
    }
}
