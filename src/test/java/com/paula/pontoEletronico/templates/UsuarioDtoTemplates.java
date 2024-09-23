
package com.paula.pontoEletronico.templates;


import com.paula.pontoEletronico.usuario.dto.UsuarioDTO;

import java.time.LocalDate;


public class UsuarioDtoTemplates {


	public static UsuarioDTO getPrimeiroUsuario() {
		return new UsuarioDTO(null, "Eduarda Isabel Malu Rezende","240.545.648-60","eduardaisabelmalurezende@br.nestle.com", LocalDate.now());
	}

	public static UsuarioDTO getSegundoUsuario() {
		return new UsuarioDTO(null, "Raimundo Geraldo Vitor Bernardes","869.096.154-25","raimundogeraldovitorbernardes-84@destaco.com", LocalDate.now());
	}

	public static UsuarioDTO getUsuarioSemNome() {
		return new UsuarioDTO(null, null,"679.098.414-34","mmarcosvinicius@unitau.br", LocalDate.now());
	}

	public static UsuarioDTO getUsuarioPontoUm() {
		return new UsuarioDTO(1L, null,null,null, null);
	}
}
