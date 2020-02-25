package com.paula.pontoEletronico.usuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.paula.pontoEletronico.usuario.model.Usuario;
import com.paula.pontoEletronico.usuario.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Usuario inserir(@RequestBody Usuario usuario) {
		return usuarioService.salvarNovoUsuario(usuario);
	}
	
	@GetMapping("/{id}")
	public Usuario consulta(@PathVariable Long id) {
		return usuarioService.consulta(id);
	}
	
	@PutMapping("/{id}")
	public Usuario altualizar(@RequestBody Usuario usuario, @PathVariable Long id) {
		return usuarioService.salvarAlteracaoUsuario(usuario, id);
	}
	
	@GetMapping("/lista")
	public List<Usuario> lista(){
		return usuarioService.lista();
	}
	
	
}
