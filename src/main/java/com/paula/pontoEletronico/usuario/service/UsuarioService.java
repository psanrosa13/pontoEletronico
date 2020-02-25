package com.paula.pontoEletronico.usuario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paula.pontoEletronico.usuario.exception.UsuarioInexistenteException;
import com.paula.pontoEletronico.usuario.model.Usuario;
import com.paula.pontoEletronico.usuario.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario salvarNovoUsuario(Usuario usuario) {
		usuario.setId(null);
		
		return usuarioRepository.save(usuario);
	}
	
	public Usuario salvarAlteracaoUsuario(Usuario usuario, Long id) {
		Optional<Usuario> usuarioCadastrado = usuarioRepository.findById(id);
		
		if(!usuarioCadastrado.isPresent()) {
			throw new UsuarioInexistenteException();
		}
		
		usuarioCadastrado.get().setCpf(usuario.getCpf());
		usuarioCadastrado.get().setEmail(usuario.getEmail());
		usuarioCadastrado.get().setNomeCompleto(usuario.getNomeCompleto());

		return usuarioRepository.save(usuarioCadastrado.get());
	}
	
	public Usuario consulta(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		if(!usuario.isPresent()) {
			throw new UsuarioInexistenteException();
		}
	
		return usuario.get();
	}

	public List<Usuario> lista() {
		return usuarioRepository.findAll();
	}
}
