package com.paula.pontoEletronico.usuario.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paula.pontoEletronico.usuario.entity.UsuarioEntity;
import com.paula.pontoEletronico.usuario.exception.UsuarioInexistenteException;
import com.paula.pontoEletronico.usuario.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	private UsuarioRepository usuarioRepository;

	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public UsuarioEntity salvar(UsuarioEntity usuario) {
		usuario.setDataDeCadastro(LocalDate.now());
		
		return usuarioRepository.save(usuario);
	}
	
	public UsuarioEntity atualizar(UsuarioEntity usuario, Long id) {
		Optional<UsuarioEntity> usuarioCadastrado = usuarioRepository.findById(id);
		
		if(!usuarioCadastrado.isPresent()) {
			throw new UsuarioInexistenteException();
		}
		
		usuarioCadastrado.get().setCpf(usuario.getCpf());
		usuarioCadastrado.get().setEmail(usuario.getEmail());
		usuarioCadastrado.get().setNomeCompleto(usuario.getNomeCompleto());

		return usuarioRepository.save(usuarioCadastrado.get());
	}
	
	public UsuarioEntity consultar(Long id) {
		Optional<UsuarioEntity> usuario = usuarioRepository.findById(id);
		
		if(!usuario.isPresent()) {
			throw new UsuarioInexistenteException();
		}
	
		return usuario.get();
	}

	public List<UsuarioEntity> listar() {
		return usuarioRepository.findAll();
	}
}
