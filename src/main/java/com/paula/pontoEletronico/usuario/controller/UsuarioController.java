package com.paula.pontoEletronico.usuario.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.paula.pontoEletronico.usuario.converter.UsuarioConverter;
import com.paula.pontoEletronico.usuario.dto.UsuarioDTO;
import com.paula.pontoEletronico.usuario.entity.UsuarioEntity;
import com.paula.pontoEletronico.usuario.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	UsuarioService usuarioService;

	UsuarioConverter usuarioConverter;

	public UsuarioController(UsuarioService usuarioService, UsuarioConverter usuarioConverter) {
		this.usuarioService = usuarioService;
		this.usuarioConverter = usuarioConverter;
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public UsuarioDTO inserir(@RequestBody UsuarioDTO usuario) {
		UsuarioEntity usuarioEntity =
				usuarioService.salvar(usuarioConverter.convertFromEntity(usuario));
		
		return usuarioConverter.convertFromDTO(usuarioEntity);
	}
	
	@GetMapping("/{id}")
	public UsuarioDTO consultar(@PathVariable Long id) {
		return usuarioConverter.convertFromDTO(usuarioService.consultar(id));
	}
	
	@PutMapping("/{id}")
	public UsuarioDTO altualizar(@RequestBody UsuarioDTO usuario, @PathVariable Long id) {
		UsuarioEntity usuarioEntity = 
				usuarioService.atualizar(usuarioConverter.convertFromEntity(usuario), id);
		
		return usuarioConverter.convertFromDTO(usuarioEntity);
	}
	
	@GetMapping
	public List<UsuarioDTO> lista(){
		return usuarioConverter.createFromDtos(usuarioService.listar());
	}
	
	
}
