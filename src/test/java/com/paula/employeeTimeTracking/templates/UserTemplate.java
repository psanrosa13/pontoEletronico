
package com.paula.employeeTimeTracking.templates;


import com.paula.employeeTimeTracking.user.dto.UserDTO;

import java.time.LocalDate;


public class UserTemplate {


	public static UserDTO getPrimeiroUsuario() {
		return new UserDTO(null, "Eduarda Isabel Malu Rezende","240.545.648-60","eduardaisabelmalurezende@br.nestle.com", LocalDate.now());
	}

	public static UserDTO getSegundoUsuario() {
		return new UserDTO(null, "","869.096.154","raimundogeraldovitorbernardes-84@destaco.com", LocalDate.now());
	}

	public static UserDTO getUsuarioSemNome() {
		return new UserDTO(null, null,"679.098.414-34","mmarcosvinicius@unitau.br", LocalDate.now());
	}

	public static UserDTO getUsuarioPontoUm() {
		return new UserDTO(1L, null,null,null, null);
	}
}
