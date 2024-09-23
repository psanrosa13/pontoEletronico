package com.paula.pontoEletronico.ponto.converter;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.paula.pontoEletronico.ponto.dto.PontoEletronicoDTO;
import com.paula.pontoEletronico.ponto.entity.PontoEletronicoEntity;

@Component
public class PontoEletronicoConverter {

	private final ModelMapper modelMapper;

	public PontoEletronicoConverter(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	public PontoEletronicoEntity convertFromEntity(PontoEletronicoDTO pontoEletronicoDTO){
		return modelMapper.map(pontoEletronicoDTO, PontoEletronicoEntity.class);
		}

	public PontoEletronicoDTO convertFromDTO(PontoEletronicoEntity pontoEletronicoEntity){
		return	modelMapper.map(pontoEletronicoEntity, PontoEletronicoDTO.class);

	}
	
	public List<PontoEletronicoDTO> createFromDtos(Collection<PontoEletronicoEntity> entities) {
	    return entities.stream().map(this::convertFromDTO).collect(Collectors.toList());
	}

	public List<PontoEletronicoEntity> createFromEntities(Collection<PontoEletronicoDTO> dtos) {
	    return dtos.stream().map(this::convertFromEntity).collect(Collectors.toList());
	 }
}
