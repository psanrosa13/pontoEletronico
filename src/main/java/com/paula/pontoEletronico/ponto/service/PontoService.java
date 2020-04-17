package com.paula.pontoEletronico.ponto.service;

import com.paula.pontoEletronico.ponto.dto.JornadaDTO;
import com.paula.pontoEletronico.ponto.entity.PontoEletronicoEntity;

public interface PontoService {

	PontoEletronicoEntity incluirNovo(PontoEletronicoEntity ponto);
	
	JornadaDTO listaRegistrosDePonto(Long id);
	
}
