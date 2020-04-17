package com.paula.pontoEletronico.usuario.converter;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.paula.pontoEletronico.usuario.dto.UsuarioDTO;
import com.paula.pontoEletronico.usuario.entity.UsuarioEntity;

@Component
public class UsuarioConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public UsuarioEntity convertFromEntity(UsuarioDTO usuarioDTO){
		UsuarioEntity usuarioEntity = modelMapper.map(usuarioDTO, UsuarioEntity.class);
	
		return usuarioEntity;
	}

	public UsuarioDTO convertFromDTO(UsuarioEntity usuarioEntity){
		UsuarioDTO usuarioDTO = modelMapper.map(usuarioEntity, UsuarioDTO.class);
	
		return usuarioDTO;
	}
	
	public List<UsuarioDTO> createFromDtos(Collection<UsuarioEntity> entities) {
	    return entities.stream().map(this::convertFromDTO).collect(Collectors.toList());
	}

	public List<UsuarioEntity> createFromEntities(Collection<UsuarioDTO> dtos) {
	    return dtos.stream().map(this::convertFromEntity).collect(Collectors.toList());
	 }
}
