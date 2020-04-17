package com.paula.pontoEletronico.ponto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paula.pontoEletronico.ponto.converter.PontoEletronicoConverter;
import com.paula.pontoEletronico.ponto.dto.JornadaDTO;
import com.paula.pontoEletronico.ponto.dto.PontoEletronicoDTO;
import com.paula.pontoEletronico.ponto.entity.PontoEletronicoEntity;
import com.paula.pontoEletronico.ponto.service.PontoService;

@RestController
@RequestMapping("/ponto")
public class PontoEletronicoController {

	@Autowired
	private PontoService pontoService;
	
	@Autowired
	private PontoEletronicoConverter pontoEletronicoConverter;
	
	@PostMapping
	public PontoEletronicoDTO inserir(@RequestBody PontoEletronicoDTO ponto) {
		PontoEletronicoEntity  pontoEletronicoEntity = 
				pontoService.incluirNovo(pontoEletronicoConverter.convertFromEntity(ponto));
		
		return pontoEletronicoConverter.convertFromDTO(pontoEletronicoEntity);
	}
	
	@GetMapping("/usuario/{id}/jornada")
	public JornadaDTO consultar(@PathVariable Long id) {
		return pontoService.listaRegistrosDePonto(id);
	}
	
}
