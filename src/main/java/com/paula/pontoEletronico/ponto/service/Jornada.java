package com.paula.pontoEletronico.ponto.service;

import java.util.List;

import com.paula.pontoEletronico.ponto.model.Ponto;

public class Jornada {

	private Long total;
	private List<Ponto> registros;
	
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public List<Ponto> getRegistros() {
		return registros;
	}
	public void setRegistros(List<Ponto> registros) {
		this.registros = registros;
	}
	
	
}
