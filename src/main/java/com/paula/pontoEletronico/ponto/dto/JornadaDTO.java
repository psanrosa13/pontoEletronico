package com.paula.pontoEletronico.ponto.dto;

import java.util.List;

public class JornadaDTO {

	private Long total;
	private List<PontoEletronicoDTO> registros;
	
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public List<PontoEletronicoDTO> getRegistros() {
		return registros;
	}
	public void setRegistros(List<PontoEletronicoDTO> registros) {
		this.registros = registros;
	}
	
	
}
