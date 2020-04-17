package com.paula.pontoEletronico.usuario.service;

import java.util.List;

import com.paula.pontoEletronico.usuario.entity.UsuarioEntity;

public interface UsuarioService {

	UsuarioEntity salvar(UsuarioEntity usuario);
	
	UsuarioEntity atualizar(UsuarioEntity usuario, Long id);
	
	UsuarioEntity consultar(Long id);
	
	List<UsuarioEntity> listar();
}
