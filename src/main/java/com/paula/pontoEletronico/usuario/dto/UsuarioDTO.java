package com.paula.pontoEletronico.usuario.dto;

import java.time.LocalDate;

public record UsuarioDTO (Long id, String nomeCompleto, String cpf, String email, LocalDate dataDeCadastro){
	
}
