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
	
	@Autowired
	private ModelMapper modelMapper;
	
	public PontoEletronicoEntity convertFromEntity(PontoEletronicoDTO pontoEletronicoDTO){
		PontoEletronicoEntity pontoEletronicoEntity = 
				modelMapper.map(pontoEletronicoDTO, PontoEletronicoEntity.class);
	
		return pontoEletronicoEntity;
	}

	public PontoEletronicoDTO convertFromDTO(PontoEletronicoEntity pontoEletronicoEntity){
		PontoEletronicoDTO pontoEletronicoDTO = 
				modelMapper.map(pontoEletronicoEntity, PontoEletronicoDTO.class);
	
		return pontoEletronicoDTO;
	}
	
	public List<PontoEletronicoDTO> createFromDtos(Collection<PontoEletronicoEntity> entities) {
	    return entities.stream().map(this::convertFromDTO).collect(Collectors.toList());
	}

	public List<PontoEletronicoEntity> createFromEntities(Collection<PontoEletronicoDTO> dtos) {
	    return dtos.stream().map(this::convertFromEntity).collect(Collectors.toList());
	 }
}
