package com.paula.pontoEletronico.templates;

import java.time.LocalDateTime;
import java.time.Month;

import com.paula.pontoEletronico.ponto.dto.PontoEletronicoDTO;
import com.paula.pontoEletronico.ponto.entity.TipoPontoEnum;

public class PontoEletronicoTemplate {

	public static PontoEletronicoDTO getPontoEntradaSegunda(){
		return new PontoEletronicoDTO(null, UsuarioDtoTemplates.getUsuarioPontoUm(), LocalDateTime.of(2020, Month.APRIL, 13, 12, 30), TipoPontoEnum.ENTRADA);
	}

	public static PontoEletronicoDTO getPontoSaidaSegunda(){
		return new PontoEletronicoDTO(null, UsuarioDtoTemplates.getUsuarioPontoUm(), LocalDateTime.of(2020, Month.APRIL, 13, 18, 20), TipoPontoEnum.SAIDA);
	}

}
